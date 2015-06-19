-- INSERT AVIONES
insert into avion(id,nombre) values ((select hibernate_sequence.nextval from dual),'AV01');
insert into avion(id,nombre) values ((select hibernate_sequence.nextval from dual),'AV02');
insert into avion(id,nombre) values ((select hibernate_sequence.nextval from dual),'AV03');

--INSERT ASIENTOS AVION 01
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'A1',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'A2',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'A3',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'A4',0);


--INSERT ASIENTOS AVION 02
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'B1',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'B2',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'B3',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'B4',0);

--INSERT ASIENTOS AVION 03
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'C1',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'C2',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'C3',0);
insert into asiento(id,nombre,ocupado) values ((select hibernate_sequence.nextval from dual),'C4',0);

insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV01'),(select id from asiento where nombre='A1'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV01'),(select id from asiento where nombre='A2'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV01'),(select id from asiento where nombre='A3'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV01'),(select id from asiento where nombre='A4'));

insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV02'),(select id from asiento where nombre='B1'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV02'),(select id from asiento where nombre='B2'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV02'),(select id from asiento where nombre='B3'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV02'),(select id from asiento where nombre='B4'));


insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV03'),(select id from asiento where nombre='C1'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV03'),(select id from asiento where nombre='C2'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV03'),(select id from asiento where nombre='C3'));
insert into avion_asiento(avion_id,asientos_id) values((select id from avion where nombre='AV03'),(select id from asiento where nombre='C4'));


