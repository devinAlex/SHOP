/*ɾ���̳����ݿ�,�������*/
drop database if exists shop;
/*�������ݿ�,�����ñ���*/
create database shop default character set utf8;

use shop;
/*ɾ������Ա��*/
drop table if exists account;
/*ɾ����Ʒ����*/
drop table if exists category;
/*ɾ����Ʒ��Ϣ��*/
drop table if exists product;

/*============================*/
/* Table: ����Ա��ṹ 		  */
/*============================*/
create table account
(
   /* ����Ա���,�Զ����� */
   id                  int not null auto_increment,
   /* ����Ա��¼��  */
   login               varchar(20),
   /* ����Ա����  */
   name                varchar(20),
   /* ����Ա���� */
   pass                varchar(20),
   /* ���ñ��Ϊ���� */
   primary key (id)
);

/*=============================*/
/* Table: ��Ʒ����ṹ 		   */
/*=============================*/
create table category
(
   /* �����,�Զ����� */
   id                  int not null auto_increment,
   /* ������� */
   type                varchar(20),
   /* ����Ƿ�Ϊ�ȵ����,�ȵ������п�����ʾ����ҳ */
   hot                 bool default false,
   /* ���,���������λ����Ա���� */
   aid                  int,
   /* ���������Ϊ���� */
   primary key (id)
);

/*=============================*/
/* Table: ��Ʒ��ṹ	 		   */
/*=============================*/
create table product
(
   /* ��Ʒ���,�Զ����� */
   id                  int not null auto_increment,
   /* ��Ʒ���� */
   name                varchar(20),
   /* ��Ʒ�۸� */
   price               decimal(8,2),
   /* ��ƷͼƬ */
   pic                 varchar(200),
   /* ��Ʒ�򵥽��� */
   remark              longtext,
   /* ��Ʒ��ϸ���� */
   xremark             longtext,
   /* ��Ʒ�������� */
   date                timestamp default CURRENT_TIMESTAMP,
   /* �Ƿ�Ϊ�Ƽ���Ʒ,�Ƽ���Ʒ���п�����ʾ���̳���ҳ */
   commend             bool,
   /* �Ƿ�Ϊ��Ч��Ʒ,��Ч��Ʒ���п�����ʾ���̳���ҳ */
   open                bool,
   /* ��Ʒ���ڵ������*/
   cid                  int,
   /* ������Ʒ���Ϊ���� */
   primary key (id)
);

/*============================*/
/* Table: �û���ṹ 		  */
/*============================*/
create table user
(
   /* �û����,�Զ����� */
   id                  int not null auto_increment,
   /* �û���¼�� */
   login               varchar(20),
   /* �û���ʵ���� */
   name                varchar(20),
   /* �û���¼���� */
   pass                varchar(20),
   /* �û��Ա� */
   sex                 varchar(20),
   /* �û��绰 */
   phone               varchar(20),
   /* �û�Email */
   email               varchar(20),
   /* �����û����Ϊ���� */
   primary key (id)
);

/*=============================*/
/* Table: ����״̬��ṹ 		   */
/*=============================*/
create table status
(
   /* ״̬���,�Զ����� */
   id                  int not null auto_increment,
   /* ����״̬ */
   status               varchar(10),
   /* ���ö������Ϊ���� */
   primary key (id)
);
/*=============================*/
/* Table: ������ṹ	 		   */
/*=============================*/
create table forder
(
   /* �������,�Զ����� */
   id                  int not null auto_increment,
   /* �ռ������� */
   name                varchar(20),
   /* �ռ��˵绰 */
   phone               varchar(20),
   /* ������Ϣ */
   remark              varchar(20),
   /* �µ����� */
   date                timestamp default CURRENT_TIMESTAMP,
   /* �����ܽ�� */
   total               decimal(8,2),
   /* �ռ����ʱ� */
   post                varchar(20),
    /* �ռ����ʱ� */
   address             varchar(200),
   /* ����״̬ */
   sid                 int default 1,
   /* ��Ա��� */
   uid                 int,
   /* ���ö������Ϊ���� */
   primary key (id)
);
/* �޸��Զ������ĳ�ʼֵ */
ALTER TABLE forder AUTO_INCREMENT = 2013021801;

/*=============================*/
/* Table: �������ṹ 		   */
/*=============================*/

create table sorder
(
   /* ��������,�Զ����� */
   id                  int not null auto_increment,
   /* ��������Ʒ������ */
   name                varchar(20),
   /* ����ʱ��Ʒ�ļ۸� */
   price               decimal(8,2),
   /* ��������� */
   number              int not null,
   /* ������Ʒ��� */
   pid                  int,
   /* �˶�����,�����Ķ������ */
   fid                  int,
   /* ���ù�������Ϊ���� */
   primary key (id)
);


/*�����������*/
INSERT INTO account(login,name,pass) values ('admin','����Ա','admin');
INSERT INTO account(login,name,pass) values ('user','�ͷ�A','user');

INSERT INTO category (type,hot,aid) VALUES ('��ʿ����',true,1);
INSERT INTO category (type,hot,aid) VALUES ('Ůʿ����',true,1);
INSERT INTO category (type,hot,aid) VALUES ('��ͯ����',true,2);
INSERT INTO category (type,hot,aid) VALUES ('��������',false,2);


/* ��Ʒ�������� */
INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('ʥ������',2999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��������',1999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��������',3999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����������',4999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����Ůװ',199.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('ѩ��ѥ',299.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('ŷ��Ůװ',3999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('Ů������',4999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('���ܵ�����',3998.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��ʿ������',299.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����Ӳ��',599.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��ˮţ����',399.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('������',150.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('�ϰ���',199.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('�յ�',3599.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����',699.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

/* �û��������� */
INSERT INTO user (login,name,pass,sex,phone,email)
VALUES ('user','С��','user','��','13812345678','10000@qq.com');

INSERT INTO user (login,name,pass,sex,phone,email)
VALUES ('user2','С��','user2','Ů','13812345679','20000@qq.com');

/*����״̬��������*/
INSERT INTO status (status) VALUES ('δ֧��');
INSERT INTO status (status) VALUES ('��֧��');
INSERT INTO status (status) VALUES ('������');
INSERT INTO status (status) VALUES ('�������');

/*���빺�ﳵ��������*/
INSERT INTO forder (name,phone,remark,date,total,address,post,uid) VALUES ('bb','123','��ע',default,200.3,'���������','1000',1);

/*���빺�ﳵ���������*/
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('�յ�',200,1,15,2013021801);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('����',0.3,1,16,2013021801);


SELECT * FROM account;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM user;
SELECT * FROM status;
SELECT * FROM forder;
SELECT * FROM sorder;
