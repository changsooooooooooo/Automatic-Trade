select substr(trade_time, 0, length(trade_time)-2) from coin_trade;

-------------------- make_substring --------------------

insert into coin_accum_volume (code, time, volume, accumulate_volume)
select t.code, t.time, max(t.volume) as volume, max(t.accumulate_volume) as accumulate_volume
from(
        select code, substr(trade_time, 0, length(trade_time)-2) as time,
               sum(trade_volume) over(partition by substr(trade_time, 0, length(trade_time)-2) order by trade_time) as volume,
               sum(trade_volume) over(partition by code order by trade_time) as accumulate_volume from coin_trade
        order by code, time
    )t
group by t.code, t.time
order by t.code, t.time;

-------------------- make_accumulated_sum && insert query --------------------

insert into coin_min_max
select code,
       substr(trade_time, 0, length(trade_time)-2) as time,
   max(trade_price) as high,
   min(trade_price) as low from coin_trade
group by code, substr(trade_time, 0, length(trade_time)-2);

-------------------- find min&max value && insert query --------------------

insert into coin_close (code, time, close, timestamp)
select t.code,
       substr(t.trade_time, 0, length(trade_time)-2) as time,
       t.trade_price as close,
       t.time_stamp as time_stamp
from(
    select
    code, trade_time, trade_price, to_timestamp(trade_timestamp/1000) +'9hours' as time_stamp
    from coin_trade
    where (code, trade_time) in (
    select code, max(trade_time) as trade_time
    from coin_trade group by code, substr(trade_time, 0, length(trade_time)-2)
    )
    ) t
order by code, time;

-------------------- find latest value group by trade time && make long time stamp to real timestamp type && insert query --------------------

insert into coin_open
select t.code,
       substr(t.trade_time, 0, length(trade_time)-2) as time,
       t.trade_price as open
from(
    select
    code, trade_time, trade_price
    from coin_trade
    where (code, trade_time) in (
    select code, min(trade_time) as trade_time
    from coin_trade group by code, substr(trade_time, 0, length(trade_time)-2)
    )
    ) t
order by code, time;

-------------------- find first value group by trade_time && insert query --------------------

insert into coin_train
select mm.code as market,
       cc.timestamp as time,
       cc.close as close,
       mm.high as high,
       mm.low as low,
       co.open as open,
       (cav.volume*((co.open+mm.low+mm.high)/3))/cav.accumulate_volume as vwap
from coin_min_max mm
    left outer join coin_open co on mm.code = co.code and mm.time = co.time
    left outer join coin_close cc on mm.code = cc.code and mm.time = cc.time
    left outer join coin_accum_volume cav on mm.code = cav.code and mm.time = cav.time
order by market, time;

--------------------  left outer join && insert query --------------------

select to_timestamp(trade_timestamp/1000)+'9hours' from coin_trade;

--------------------  make ust to kst && insert query --------------------
