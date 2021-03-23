#create database ProyectoG9

use ProyectoG9;


create table if not exists Persona(
	id varchar(15) primary key
);

create table if not exists Empleado(
	id varchar(15) primary key,
    primer_nombre varchar(20),
    segundo_nombre varchar(20),
    primer_apeelido varchar(20),
    segundo_apellido varchar(20),
    cargo varchar(15),
    foreign key (id) references Persona(id)
);

create table if not exists Cliente(
	id varchar(15) primary key,
    nombreCliente varchar(30),
    foreign key (id) references Persona(id)
);

create table if not exists Proveedor(
	id varchar(15) primary key,
    nombre varchar(20),
    apellido varchar(20),
    alias varchar(20),
    foreign key (id) references Persona(id)
);

create table if not exists Pagos(
	codigo_p int auto_increment primary key,
    empleado varchar(15),
    proveedor varchar(15),
    foreign key (empleado) references Empleado(id),
    foreign key (proveedor) references Proveedor(id)
);

create table if not exists Vehiculo(
	codVehiculo int auto_increment,
    matricula varchar(8) not null,
    modelo varchar(8),
    capacididad varchar(20),
    kilometraje float not null,
    año varchar(4) not null,
    tipo_viaje varchar (20) default 'normal',
    primary key(codVehiculo,matricula)
);

create table if not exists Viaje(
	codigo int auto_increment primary key,
    ruta varchar(50),
    fecha_salida datetime,
    fecha_llegada datetime,
    descripcion_viaje varchar(50),
    empleado varchar(15),
    vehiculo varchar(8) not null,
    codVehiculo int,
    foreign key (empleado) references Empleado(id),
    foreign key (codVehiculo,vehiculo) references Vehiculo(codVehiculo,matricula)
);

create table if not exists Mano_Obra(
	cod int auto_increment primary key,
    mantenimiento varchar(30) not null,
    repuesto varchar(30),
    vehiculo int not null,
    matricula varchar(8) not null,
    fecha_mantenimiento datetime,
    foreign key (vehiculo,matricula) references Vehiculo(codVehiculo,matricula)
);

create table if not exists factura_viaje (
	num_defactura int auto_increment primary key,
	fecha_registro date,
    descripcion varchar(50) not null, 
    valor float not null,
    articulo varchar(20) default 'latas',
    viaje int,
    cliente varchar(15),
    foreign key(viaje) References Viaje(codigo),   
    foreign key(cliente) References cliente(id)
);



create table if not exists factura_proveedor (	
	num_defactura int auto_increment primary key,
    fecha_registro date,
    descripcion varchar(50) ,
    valor float not null,	
    mano_obra int,
    proveedor varchar(15),
    foreign key(proveedor) References Proveedor(id),
    foreign key(mano_obra) References Mano_Obra(cod)
);



#insertar los pleados que existen(max10 ) sin importar si son clientes , proveedores, empleados 
insert into Persona(id) value('1304123221');
insert into Persona(id) value('0011304123221');
insert into Persona(id) value('0928419662');
insert into Persona(id) value('0010928419662');
insert into Persona(id) value('0012397432723');
insert into Persona(id) value('0010912213135');
insert into Persona(id) value('1214265322');
insert into Persona(id) value('1201761512');
insert into Persona(id) value('0011243252356');
insert into Persona(id) value('1231242152');


#inserrtar los datos empleados
insert into Empleado(id,primer_nombre,segundo_nombre,primer_apeelido,segundo_apellido,cargo)
value('1304123221','Hector','Fabricio','Rosales','Armijos','chofer');
insert into Empleado(id,primer_nombre,segundo_nombre,primer_apeelido,segundo_apellido,cargo)
value('0928419662','Juan','Alberto','Zurita','Añasco','chofer');
insert into Empleado(id,primer_nombre,segundo_nombre,primer_apeelido,segundo_apellido,cargo)
value('1214265322','Darwin','Jose','Plazarte','Gutierres','chofer');

#añadir los clientes
insert into Cliente(id,nombreCliente) value ('0011304123221','FADESA');
insert into Cliente(id,nombreCliente) value ('0010928419662','ENLIT');
insert into Cliente(id,nombreCliente) value ('0012397432723','ISABEL SA');
insert into Cliente(id,nombreCliente) value ('0010912213135','SALICA');
insert into Cliente(id,nombreCliente) value ('0011243252356','EUROFISCH');


#añadir lso proveedores
insert into Proveedor(id,nombre,apellido,alias) value ('1201761512','Darling','Canales','Pepo');
insert into Proveedor(id,nombre,apellido,alias) value ('1231242152','Edisson','Molina','Gato');

#añadir pagos
insert into Pagos(proveedor) value ('1201761512');
insert into Pagos(empleado) value ('1304123221');
insert into Pagos(proveedor) value ('1231242152');
insert into Pagos(empleado) value ('0928419662');
insert into Pagos(empleado) value ('1214265322');


#modificacion del atibuto a capacidad en Vehiculi
#alter table Vehiculo modify column capacidad varchar(20);

#añadir vehiculo
insert into Vehiculo(matricula, modelo, capacididad, kilometraje, año, tipo_viaje) value('PRD-0000', 'FORD', '25 toneladas','10000.0','2015','ida');
insert into Vehiculo(matricula, modelo, capacididad, kilometraje, año, tipo_viaje) value('PZR-2341', 'JAC', '30 toneladas','50000.0','2012','vuelta');
insert into Vehiculo(matricula, modelo, capacididad, kilometraje, año, tipo_viaje) value('GPE-3030', 'FORD', '35 toneladas','59000.00','2012','ida');
insert into Vehiculo(matricula, modelo, capacididad, kilometraje, año, tipo_viaje) value('GPA-3900', 'KODIAK', '25 toneladas','59000.00','2014','ida');
insert into Vehiculo(matricula, modelo, capacididad, kilometraje, año, tipo_viaje) value ('GRS-2345','FORD','25 toneladas','0.0','2015','ida');


#añadir los viajes que hace cada vehiculo
insert into Viaje(ruta,fecha_salida,fecha_llegada,descripcion_viaje,empleado,vehiculo,codVehiculo) 
value ('Guayaquil-Manta',08/11/15,now(),'el carro llevo latas de atun','0928419662','PZR-2341',2);
insert into Viaje(ruta,fecha_salida,fecha_llegada,descripcion_viaje,empleado,vehiculo,codVehiculo) 
value ('Manta-La maná',08/11/15,10/11/15,'el carro llevo latas de atun','1214265322','GRS-2345',5);
insert into Viaje(ruta,fecha_salida,fecha_llegada,descripcion_viaje,empleado,vehiculo,codVehiculo) 
value ('Manta-La maná',now(),13/11/15,'tanques de agua','1304123221','GPA-3900',4);
insert into Viaje(ruta,fecha_salida,fecha_llegada,descripcion_viaje,empleado,vehiculo,codVehiculo) 
value ('Manta - Guayaquil',now(),13/11/15,'tanques de agua','1214265322','GPE-3030',3);
insert into Viaje(ruta,fecha_salida,fecha_llegada,descripcion_viaje,empleado,vehiculo,codVehiculo) 
value ('Manta - Guayaquil',12/11/15,13/11/15,'latas de atun','0928419662','PRD-0000',1);

#cambiar la fecha en vehiculo

#cambiar el atributo de fecha_llegada y fecha_salida
alter table Viaje modify column fecha_salida date;
alter table Viaje modify column fecha_llegada date;

#insertar el mantenimiento que sele hicieron a los autos el ultimo mes
insert into Mano_Obra(mantenimiento,repuesto,vehiculo,matricula,fecha_mantenimiento)
value('cambio de aceite','aceite al kendall',2,'PZR-2341',now());
insert into Mano_Obra(mantenimiento,repuesto,vehiculo,matricula,fecha_mantenimiento)
value('cambio de aceite','aceite al kendall',3,'GPE-3030',18/11/9);


#alter table Mano_Obra drop column fecha_mantenimiento;
alter table Mano_Obra add column fecha_m varchar (13); 
update Mano_Obra set fecha_m ='Septiembre'
where  cod =1;
update Mano_Obra set fecha_m ='octubre'
where  cod =2;
update Mano_Obra set fecha_m ='octubre'
where  cod =3;
update Mano_Obra set fecha_m ='noviembre'
where  cod =4;
update Mano_Obra set fecha_m ='noviembre' #and mantenimiento = 'cambio de llanta' and repuesto = 'llantas para cammion'
where  cod =5;
update Mano_Obra set fecha_m ='noviembre' #and mantenimiento = 'mantenimiemto sistema electrico' and repuesto = 'N/A'
where  cod =6;
update Mano_Obra set fecha_m ='noviembre' #and mantenimiento = 'cambio de filtro de gasolina' and repuesto = 'filtro de gasolina'
where  cod =7;
update Mano_Obra set fecha_m ='noviembre' #and mantenimiento = 'cambio de zapatillas de freno' and repuesto = 'zapatillas de freno'
where  cod =8;
update Mano_Obra set mantenimiento = 'cambio filtro gasolina'
where cod = 7;
update Mano_Obra set mantenimiento = 'limpieza de filtro de aire'
where cod=6;
update Mano_Obra set repuesto='NA'
where cod=6;
update Mano_Obra set mantenimiento ='revision sistema electrico' 
where cod=8;
update Mano_Obra set repuesto='NA'
Where cod=8;
update Viaje set fecha_salida ='18/11/15'
where codigo=1;
update Viaje set fecha_salida ='18/11/12'
where codigo=2;
update Viaje set fecha_llegada ='18/11/13'
where codigo=2;
update Viaje set fecha_salida ='18/11/6'
where codigo=3;
update Viaje set fecha_llegada ='18/11/6'
where codigo=3;
update Viaje set fecha_salida ='18/11/8'
where codigo=4;
update Viaje set fecha_llegada ='18/11/9'
where codigo=4;
update Viaje set fecha_salida ='18/11/8'
where codigo=7;
update Viaje set fecha_llegada ='18/11/8'
where codigo=7;

#mostrar las personas registradas
insert into factura_viaje (fecha_registro ,descripcion,valor,articulo,viaje,cliente)
value('18/11/15','24 pallets latas de atun',140.00,'latas',1,'0010928419662');
insert into factura_viaje (fecha_registro ,descripcion,valor,articulo,viaje,cliente)
value('18/11/12','42 pallets latas de atun',260.00,'latas',2,'0011304123221');
insert into factura_viaje (fecha_registro ,descripcion,valor,articulo,viaje,cliente)
value('18/11/06','15 tanques de agua',130.00,'Tanques',3,'0010912213135');
insert into factura_viaje (fecha_registro ,descripcion,valor,articulo,viaje,cliente)
value('18/11/08','20 tanques de agua',160.00,'Tanques',4,'0010912213135');
insert into factura_viaje (fecha_registro ,descripcion,valor,articulo,viaje,cliente)
value('18/11/08','42 pallets latas de atun',260.00,'Latas',7,'0011243252356');

insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/09/23','cambio de aceite',45.50,1,'1201761512');
insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/10/10','cambio de aceite',45.50,2,'1201761512');
insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/10/18','cambio de aceite',35.50,3,'1201761512');
insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/11/13','cambio de aceite',45.50,4,'1201761512');
insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/11/4','cambio de aceite',35.50,5,'1201761512');
insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/11/7','cambio de aceite',45.50,6,'1231242152');
insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/11/14','cambio de aceite',45.50,7,'1231242152');
insert into factura_proveedor(fecha_registro,descripcion,valor,mano_obra,proveedor)
value('18/11/9','cambio de aceite',45.50,8,'1231242152');

#tabla empleados
select id,primer_nombre,primer_apeelido,cargo from Empleado;

#tabla empleados
select id,nombreCliente from Cliente;

#tabla empleados
select id,nombre,apellido,alias from Proveedor;

#tabla pagos
select codigo_p,proveedor,empleado from Pagos;

#Mostrar los datos  de los Vehiculos
select codVehiculo, matricula, modelo from Vehiculo;

#mostrar los viajes
select codigo, ruta, fecha_salida, fecha_llegada,descripcion_viaje,empleado,vehiculo from Viaje;

#MOSTRAR TABLA MANO DE OBRA
select cod, mantenimiento, repuesto,matricula,fecha_m from Mano_Obra; 

#tabla factura_viaje
select num_defactura,fecha_registro ,descripcion,valor,articulo,viaje,cliente from factura_viaje;

#tabla Proveeor

select num_defactura,fecha_registro ,descripcion,valor,mano_obra,proveedor from factura_proveedor;