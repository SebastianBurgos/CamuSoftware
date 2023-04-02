CREATE DATABASE camu_soporte;

USE camu_soporte;

CREATE TABLE `Usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL,
	`apellidos` VARCHAR(50) NOT NULL,
	`cedula` VARCHAR(20) NOT NULL,
	`telefono` VARCHAR(20) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`direccion` VARCHAR(50),
	`ciudad_residencia` VARCHAR(50),
	`password` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `EstadoDesarrollador` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`estado` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Desarrollador` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_estado` INT NOT NULL,
	`cedula` VARCHAR(20) NOT NULL,
	`nombre` VARCHAR(50) NOT NULL,
	`apellidos` VARCHAR(50) NOT NULL,
	`telefono` VARCHAR(20) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`direccion` VARCHAR(30),
	`password` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`id_estado`) REFERENCES EstadoDesarrollador(`id`)
);

CREATE TABLE `Modulo` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL,
	`descripcion` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `TipoImplementacion` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`tipo` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Monitoreo` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`descripcion` VARCHAR(50) NOT NULL,
	`tipo` VARCHAR(50) NOT NULL,
	`estado` VARCHAR(50) NOT NULL,
	`observaciones` INT(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Plataforma` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `TipoPQRS` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(20) NOT NULL,
	`descripcion` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `PQRS` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_usuario` INT NOT NULL,
	`id_plataforma` INT NOT NULL,
	`id_modulo` INT NOT NULL,
	`id_tipo` INT NOT NULL,
	`detalles` VARCHAR(100) NOT NULL,
	`asunto` VARCHAR(50) NOT NULL,
	`fecha_solicitud` DATETIME NOT NULL,
	`estado` VARCHAR(50),
	PRIMARY KEY (`id`),
	FOREIGN KEY (`id_usuario`) REFERENCES Usuario(`id`),
	FOREIGN KEY (`id_plataforma`) REFERENCES Plataforma(`id`),
	FOREIGN KEY (`id_modulo`) REFERENCES Modulo(`id`),
	FOREIGN KEY (`id_tipo`) REFERENCES TipoPQRS(`id`)
);

CREATE TABLE `Soporte` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_pqrs` INT NOT NULL,
	`estado` VARCHAR(50) NOT NULL,
	`tipo` VARCHAR(50) NOT NULL,
	`fecha_creacion` DATETIME NOT NULL,
	`fecha_ultima_actualizacion` DATETIME NOT NULL,
	`tiempo_respuesta` VARCHAR(50) NULL,
	`observaciones` VARCHAR(100) NULL,
	`respuesta` VARCHAR(100) NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`id_pqrs`) REFERENCES PQRS(`id`)
);

CREATE TABLE `Documentacion` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_soporte` INT NOT NULL,
	`titulo` VARCHAR(50) NOT NULL,
	`descripcion` VARCHAR(100) NOT NULL,
	`autor` VARCHAR(50) NOT NULL,
	`fecha_creacion` DATETIME NOT NULL,
	`fecha_ultima_modificacion` DATETIME NOT NULL,
	`tema` VARCHAR(50) NOT NULL,
	`version` VARCHAR(20) NOT NULL,
	`estado` VARCHAR(30) NOT NULL,
	`proposito` VARCHAR(50) NOT NULL,
	`observaciones` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`id_soporte`) REFERENCES Soporte(`id`)
);

CREATE TABLE `Implementacion` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_soporte` INT NOT NULL,
	`especificacion` VARCHAR(100) NOT NULL,
	`fecha_implementacion` DATETIME NOT NULL,
	`horas_invertidas` INT NOT NULL,
	`estado` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`id_soporte`) REFERENCES Soporte(`id`)
);

CREATE TABLE `SoporteAsignado` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`id_desarrollador` INT NOT NULL,
	`id_soporte` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`id_desarrollador`) REFERENCES Desarrollador(`id`),
	FOREIGN KEY (`id_soporte`) REFERENCES Soporte(`id`)
);

insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (1, 'Sylvia', 'Heddy', '88-753-0263', '+86 (850) 762-1176', 'sheddy0@reddit.com', 'PO Box 59741', 'Liujiachang', '8pxs18B');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (2, 'Clarence', 'Fildes', '55-103-6490', '+86 (213) 436-6313', 'cfildes1@amazon.co.jp', 'PO Box 91049', 'Gaojialing', 'ZRq4wcTOTkW');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (3, 'Bethanne', 'Blackler', '03-229-9286', '+241 (675) 701-6056', 'bblackler2@nba.com', 'Suite 21', 'Ndendé', 'OPOA5U2');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (4, 'Sheff', 'FitzAlan', '79-424-7101', '+57 (739) 445-5991', 'sfitzalan3@clickbank.net', 'Suite 18', 'Granada', 'YLxDqBcKDd5C');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (5, 'Caprice', 'Kochlin', '64-650-3292', '+33 (340) 596-9185', 'ckochlin4@earthlink.net', 'Apt 1214', 'Nantes', 'GERd56w');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (6, 'Truman', 'Bovey', '83-093-1142', '+62 (730) 976-4501', 'tbovey5@imdb.com', 'Suite 32', 'Bader', 'EHeNa4dov8ma');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (7, 'Virgil', 'Denial', '72-808-3253', '+55 (200) 477-7644', 'vdenial6@reddit.com', 'Apt 653', 'Jutaí', '8KywVrp');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (8, 'Cyb', 'Kleinmintz', '28-742-6158', '+86 (209) 486-4807', 'ckleinmintz7@surveymonkey.com', 'Room 513', 'Nanhe', 'AU1sALY');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (9, 'Philbert', 'Schneider', '85-433-3939', '+33 (751) 235-7571', 'pschneider8@marriott.com', 'PO Box 147', 'Montpellier', 'HmLoYjhfFH');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (10, 'Ailbert', 'Ffoulkes', '83-297-1885', '+66 (506) 937-7144', 'affoulkes9@free.fr', 'PO Box 40683', 'Bang Ban', 'RNGYbIy');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (11, 'Allard', 'Sparkes', '13-913-8377', '+256 (350) 462-2731', 'asparkesa@desdev.cn', 'Suite 29', 'Kaliro', 'hWOBBGt');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (12, 'Codie', 'Mulmuray', '29-777-4273', '+46 (963) 166-3723', 'cmulmurayb@addthis.com', 'Suite 55', 'Hägersten', 'wMxDt8');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (13, 'Madison', 'Kitcher', '90-833-1071', '+251 (454) 418-0889', 'mkitcherc@wp.com', 'Suite 86', 'Bichena', 'bBuOFjNrelPA');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (14, 'Juliet', 'Hallede', '65-400-2899', '+63 (465) 603-0206', 'jhalleded@blog.com', 'Apt 1206', 'Jalaud', 'kzDNd7x');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (15, 'Errol', 'Colebourne', '91-514-5194', '+62 (639) 433-1648', 'ecolebournee@free.fr', 'Suite 3', 'Bendo', 'i0J36Z5O9X');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (16, 'Alessandra', 'Tolworthie', '37-499-0955', '+351 (419) 626-5032', 'atolworthief@flavors.me', 'Room 1722', 'Astromil', 'yeSirChjt');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (17, 'Yulma', 'Mattiussi', '97-238-7692', '+62 (322) 924-5152', 'ymattiussig@ihg.com', 'PO Box 55571', 'Tambakan', 'CKGzORx');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (18, 'Bella', 'Kohn', '48-163-6659', '+1 (903) 709-5316', 'bkohnh@bing.com', 'PO Box 19192', 'Brades', '8dSGSnd');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (19, 'Tova', 'Okroy', '42-493-5848', '+55 (703) 112-0070', 'tokroyi@webs.com', 'Room 555', 'Itapetinga', 'evDpgSaHHbNS');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (20, 'Alan', 'Poulett', '43-416-9274', '+33 (759) 546-9118', 'apoulettj@ucsd.edu', 'Apt 437', 'Guyancourt', 'EXNGUAAAn');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (21, 'Job', 'Orwin', '67-397-1314', '+62 (231) 699-8167', 'jorwink@opera.com', 'Apt 218', 'Munggang', '1kBwR0v7O');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (22, 'Carole', 'Glackin', '06-179-5148', '+212 (260) 376-9404', 'cglackinl@slashdot.org', 'Suite 43', 'Abadou', 'u3vJXR');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (23, 'Paule', 'Hails', '07-389-9164', '+86 (139) 666-3053', 'phailsm@usgs.gov', '7th Floor', 'Guangyubao', 'zkf4oAkVz');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (24, 'Mannie', 'Leimster', '61-376-0314', '+86 (170) 746-0532', 'mleimstern@answers.com', 'Room 1327', 'Aimin', '7SWijU');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (25, 'Ivette', 'Govey', '03-227-5080', '+86 (707) 692-6675', 'igoveyo@smh.com.au', 'Suite 69', 'Guoyuan', 'vRAFuG');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (26, 'Creighton', 'Cords', '75-120-7059', '+62 (789) 581-7088', 'ccordsp@quantcast.com', 'Suite 2', 'Muraharjo', 'IEnr05sR');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (27, 'Maureen', 'Croall', '14-044-0805', '+63 (328) 469-9431', 'mcroallq@blinklist.com', 'PO Box 77548', 'San Marcelino', 'Ib0eJA6rw2');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (28, 'Waylon', 'Jime', '82-742-4803', '+420 (945) 810-6259', 'wjimer@furl.net', 'Suite 57', 'Odolena Voda', 'yhaCYCFkOkp');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (29, 'Delcine', 'Shewsmith', '63-950-9625', '+7 (207) 710-2678', 'dshewsmiths@spotify.com', 'Suite 12', 'Lyalichi', 'k3R4zAxsm');
insert into usuario (id, nombre, apellidos, cedula, telefono, email, direccion, ciudad_residencia, password) values (30, 'Allyson', 'Perrington', '77-023-8175', '+62 (387) 214-7739', 'aperringtont@indiegogo.com', 'Room 1729', 'Lokuuy', 'ERHZNdw1kya');

insert into estadodesarrollador (id, estado) values (1, "Libre");
insert into estadodesarrollador (id, estado) values (2, "Ocupado");
insert into estadodesarrollador (id, estado) values (3, "En vacaciones");

insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (1, 1, '98-901-1402', 'Lindy', 'Charles', '+374 (276) 802-0407', 'lcharles0@nasa.gov', 'Suite 92', 'RwdwnanntN8q');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (2, 2, '48-686-2551', 'Eben', 'Rochelle', '+48 (271) 149-1554', 'erochelle1@guardian.co.uk', 'Suite 41', 'h0Omx8FHWh');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (3, 3, '63-114-9654', 'Cullen', 'Cutchie', '+86 (174) 951-8200', 'ccutchie2@nasa.gov', 'Room 855', 'tcsgR2VoTr');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (4, 2, '33-200-3121', 'Lillian', 'Bicknell', '+48 (741) 451-4700', 'lbicknell3@mail.ru', 'Suite 9', 'IYPEmO');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (5, 1, '11-604-7276', 'Kikelia', 'Skeermer', '+591 (673) 127-1535', 'kskeermer4@biblegateway.com', 'Room 1124', 'w8yYWXN8bUC');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (6, 3, '00-259-2699', 'Willamina', 'Dallon', '+7 (594) 600-1971', 'wdallon5@privacy.gov.au', 'Apt 588', 'XC4icT');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (7, 2, '73-498-4885', 'Lelia', 'Swoffer', '+354 (271) 560-6540', 'lswoffer6@europa.eu', 'Room 63', 'gVBlkNl');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (8, 2, '56-649-5518', 'Spense', 'Ensor', '+86 (756) 312-0572', 'sensor7@msn.com', 'Room 1397', 'gFk6T3YN41');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (9, 2, '91-040-2485', 'Farrel', 'Musker', '+383 (164) 111-7052', 'fmusker8@china.com.cn', 'Room 930', 'buiJhEDXGpj');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (10, 2, '55-915-6599', 'Duane', 'Collum', '+62 (617) 592-8476', 'dcollum9@walmart.com', '18th Floor', 'WxQHcQq5Ii');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (11, 1, '60-713-6115', 'Saxe', 'Haselgrove', '+86 (173) 820-4159', 'shaselgrovea@exblog.jp', 'Suite 68', 'PPwGeRFKS1');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (12, 2, '22-355-2073', 'Umberto', 'Feaveryear', '+1 (803) 928-4466', 'ufeaveryearb@homestead.com', 'Room 1095', 'XuFyxvle');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (13, 3, '82-613-0128', 'Gabriella', 'Dunston', '+62 (126) 683-0609', 'gdunstonc@amazon.com', 'Room 376', 'Of8jSZWd9l');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (14, 3, '50-263-3915', 'Joanie', 'Bayless', '+381 (330) 286-3893', 'jbaylessd@odnoklassniki.ru', '6th Floor', 'YqF6QJUtH8');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (15, 1, '77-321-1439', 'Eden', 'Cordelle', '+62 (318) 369-0500', 'ecordellee@paginegialle.it', 'PO Box 93334', 'ZQuAkGLZ');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (16, 1, '80-768-3505', 'Abbe', 'Hayzer', '+355 (208) 922-3525', 'ahayzerf@netlog.com', 'Suite 58', 'kNBw2cKFI8Fq');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (17, 2, '84-199-7810', 'Windham', 'Leaves', '+389 (630) 722-0094', 'wleavesg@webnode.com', 'Room 811', 'qo2hgA');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (18, 2, '55-482-9278', 'Bentley', 'Silver', '+62 (814) 155-9903', 'bsilverh@seattletimes.com', '3rd Floor', 'QLGyGGruF');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (19, 2, '98-563-8637', 'Marijo', 'Lannon', '+46 (473) 632-4172', 'mlannoni@si.edu', '17th Floor', 'BS73sSOe3');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (20, 3, '34-576-6061', 'Gerianna', 'Maier', '+62 (973) 375-5285', 'gmaierj@parallels.com', 'Room 1890', 'GrxLpMKxNBD');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (21, 3, '46-084-0314', 'Joell', 'Churly', '+86 (447) 581-7356', 'jchurlyk@lycos.com', 'Apt 734', 'xm2HM2P');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (22, 3, '86-446-8559', 'Kaja', 'Leversuch', '+46 (386) 624-1182', 'kleversuchl@ebay.com', 'Apt 1056', 'APauhUVRvXd');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (23, 3, '38-656-4921', 'Lark', 'Eichmann', '+254 (212) 625-2757', 'leichmannm@spiegel.de', 'Room 1114', 't2bHMt');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (24, 3, '06-561-0782', 'Dasha', 'Sutch', '+86 (506) 172-7744', 'dsutchn@t.co', 'Room 457', 'wip5Cl');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (25, 1, '04-024-0812', 'Alleyn', 'Ritchley', '+7 (864) 901-3525', 'aritchleyo@businesswire.com', 'Apt 833', 'aVMbPag');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (26, 2, '13-434-1293', 'Cleavland', 'Fayer', '+1 (253) 551-4118', 'cfayerp@dropbox.com', 'Apt 1328', 'Fpe5Igx9RyR');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (27, 1, '21-800-1548', 'Alysia', 'Attenbarrow', '+62 (612) 349-7020', 'aattenbarrowq@themeforest.net', '11th Floor', 'VbHapwZJ');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (28, 2, '22-593-2685', 'Dian', 'Stote', '+389 (429) 883-1818', 'dstoter@stanford.edu', '3rd Floor', 'o2gTOLNQ');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (29, 3, '80-008-1550', 'Perice', 'Hurl', '+86 (649) 655-8463', 'phurls@behance.net', '1st Floor', 'qSVdePjUkzH');
insert into desarrollador (id, id_estado, cedula, nombre, apellidos, telefono, email, direccion, password) values (30, 1, '20-474-4337', 'Phineas', 'MacGorley', '+98 (261) 237-2955', 'pmacgorleyt@prlog.org', '2nd Floor', 'sEGcBsIs');

insert into modulo (id, nombre, descripcion) values (1, "Contabilidad", "Un modulo que permita");
insert into modulo (id, nombre, descripcion) values (2, "Proyectos", "un modulo que permita a los");
insert into modulo (id, nombre, descripcion) values (3, "Contratos", "un modulo que permita a los");
insert into modulo (id, nombre, descripcion) values (4, "Recursos Humanos", "un modulo que permita a");
insert into modulo (id, nombre, descripcion) values (5, "Inventario", " un modulo que permita a los");

insert into tipoimplementacion (id, tipo) values (1, "Actualizacion");
insert into tipoimplementacion (id, tipo) values (2, "Solucion de errores");
insert into tipoimplementacion (id, tipo) values (3, "Optimización");
insert into tipoimplementacion (id, tipo) values (4, "Reconstruccion");

insert into plataforma (id, nombre) values (1, "Web");
insert into plataforma (id, nombre) values (2, "Movil");
insert into plataforma (id, nombre) values (3, "Escritorio");

insert into tipopqrs (id, nombre, descripcion) values (1, "Peticion", "solicitar información o servicios.");
insert into tipopqrs (id, nombre, descripcion) values (2, "Queja", "expresar insatisfacción o mal servicio.");
insert into tipopqrs (id, nombre, descripcion) values (3, "Reclamo", "exigir corrección o indemnización por daños.");
insert into tipopqrs (id, nombre, descripcion) values (4, "Sugerencia", "proponer mejoras o cambios.");	