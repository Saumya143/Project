create or replace PROCEDURE BUlk_USER_INSERT
is
x number:=1;
begin
while(x<=1000)
loop
insert into USER_MASTER values(ATS_USER_SEQ.nextval,SYSTIMESTAMP,
null,'16-06-98','saumyaranjanm56m@gmail.com','Saumya',
'MALE','Mohnaty',8249761792,SYSTIMESTAMP,null);
commit;
x:=x+1;
end loop;
end;
/

EXECUTE BUlk_USER_INSERT;

create or replace PROCEDURE BUlk_TAG_INSERT
is
x number:=1;
i number:=1;
begin
while(x<=1000)
loop
insert into tag_master values(TAG_GEN_SEQ.nextval,null,
SYSTIMESTAMP - INTERVAL '1' minute,5000.00,'20-NOV-2022',i,'20-NOV-2019',
null,SYSTIMESTAMP - INTERVAL '1' minute,i,
'SD54WVD','4-WHEELER');
commit;
x:=x+1;
i:=i+1;
end loop;
end;
/

EXECUTE BULK_TAG_INSERT;

create or replace PROCEDURE BUlk_TXN_TRG_INSERT
is
x number:=1;
i number:=1;
begin
while(x<=1000)
loop
if x<500 then
insert into tag_tx_trigger VALUES(TXN_NO_SEQ.nextval,null,
SYSTIMESTAMP - INTERVAL '1' minute,'P',i,
400.00,'CFE567','LOW_BAL','Failed',null,
SYSTIMESTAMP - INTERVAL '1' minute,'SD54WVD');
else 
insert into tag_tx_trigger VALUES(TXN_NO_SEQ.nextval,null,
SYSTIMESTAMP - INTERVAL '1' minute,'C',i,
400.00,'CFE567',null,'Success',null,
SYSTIMESTAMP - INTERVAL '1' minute,'SD54WVD');
end IF;
commit;
x:=x+1;
i:=i+1;
end loop;
end;
/

EXECUTE BUlk_TXN_TRG_INSERT;