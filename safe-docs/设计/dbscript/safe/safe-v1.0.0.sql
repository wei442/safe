/********************** weiyong start 20181025 *******************************/
drop table if exists enterprise;

/*==============================================================*/
/* Table: enterprise                                            */
/*==============================================================*/
create table enterprise
(
   id                   int not null auto_increment comment '企业id',
   enterprise_name      varchar(100) not null default '' comment '企业名称',
   enterprise_type      int(1) not null default 1 comment '企业类型 1-政府部门 ,2-院校, 3-科研所, 4-国有企业, 5-集体企业, 6-股份合作企业, 7-联营企业, 8-有限责任公司, 9-股份有限公司, 10-私营企业, 11-港、澳、台商投资企业, 12-外商投资企业, 13-其他',
   enterprise_nature    int(2) not null default 1 comment '企业性质 1-国有, 2-合作, 3-合资, 4-独资, 5-集体, 6-私营, 7-个体工商户, 8-报关, 9-其他',
   enterprise_status    int(1) not null default 1 comment '企业状态 1-正常, 2-冻结, 3-注销',
   enterprise_alias     varchar(30) not null default '' comment '企业别名',
   enterprise_telphone  varchar(20) not null default '' comment '企业电话',
   enterprise_level     int(1) not null default 1 comment '企业级别',
   enterprise_fax       varchar(20) not null default '' comment '企业传真',
   enterprise_email     varchar(30) not null default '' comment '企业邮箱',
   enterprise_post_code varchar(10) not null default '' comment '企业邮编',
   enterprise_addr      varchar(100) not null default '' comment '企业地址',
   enterprise_webside   varchar(100) not null default '' comment '企业网址',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(30) not null default '' comment '创建人',
   updated              varchar(30) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table enterprise comment '企业表';

drop table if exists base_user;

/*==============================================================*/
/* Table: base_user                                             */
/*==============================================================*/
create table base_user
(
   id                   int not null auto_increment comment '基础用户id',
   user_account         varchar(100) not null default '' comment '用户账号',
   user_name            varchar(100) not null default '' comment '用户名称',
   user_name_en         varchar(100) not null default '' comment '用户英文名称',
   user_password        varchar(100) not null default '' comment '用户密码',
   user_type            int(1) not null default 1 comment '用户类型',
   user_status          int(1) not null default 1 comment '用户状态: 1-正常, 2-冻结, 3-注销',
   user_email           varchar(30) not null default '' comment '用户邮箱',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id),
   unique key uk_user_account (user_account)
);

alter table base_user comment '基础用户表';

drop table if exists base_user_login;

/*==============================================================*/
/* Table: base_user_login                                       */
/*==============================================================*/
create table base_user_login
(
   id                   int not null auto_increment comment '基础用户登录id',
   base_user_id         int not null default -1 comment '基础用户id',
   login_count          int not null default 0 comment '登录次数',
   last_pass_time       datetime not null comment '密码过期时间',
   created              varchar(30) not null default '' comment '创建人',
   updated              varchar(30) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table base_user_login comment '基础用户登录表';

drop table if exists base_user_login_log;

/*==============================================================*/
/* Table: base_user_login_log                                   */
/*==============================================================*/
create table base_user_login_log
(
   id                   bigint not null auto_increment comment '基础登录日志id',
   base_user_id         int not null default -1 comment '基础用户id',
   base_user_account    varchar(50) not null default '' comment '用户账号',
   base_user_name       varchar(50) not null default '' comment '用户名称',
   base_user_name_en    varchar(50) not null default '' comment '用户英文名称',
   login_type           int(1) not null default 1 comment '登录类型 1-登录, 2-退出',
   login_time           datetime not null comment '登录或退出时间',
   login_ip             varchar(20) not null default '' comment '登录ip',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table base_user_login_log comment '基础用户登录日志表';

drop table if exists org;

/*==============================================================*/
/* Table: org                                                   */
/*==============================================================*/
create table org
(
   id                   int not null auto_increment comment '机构id',
   enterprise_id        int not null default -1 comment '企业id',
   parent_org_id        int not null default -1 comment '机构父id',
   parent_org_name      varchar(200) not null default '' comment '机构父名称',
   parent_org_name_en   varchar(200) not null default '' comment '机构父英文名称',
   org_name             varchar(200) not null default '' comment '机构名称',
   org_name_en          varchar(200) not null default '' comment '机构英文名称',
   org_alias            varchar(200) not null default '' comment '机构别名',
   org_telphone         varchar(20) not null default '' comment '机构电话',
   org_type             int(1) not null default 1 comment '机构类型',
   org_status           int(1) not null default 1 comment '机构状态 0-无效, 1-有效',
   org_level            int(1) not null default 1 comment '机构级别',
   org_fax              varchar(20) not null default '' comment '传真',
   org_email            varchar(50) not null default '' comment '邮件',
   org_post_code        varchar(10) not null default '' comment '邮编',
   org_addr             varchar(200) not null default '' comment '地址',
   org_webside          varchar(200) not null default '' comment '网址',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table org comment '组织机构表';

drop table if exists dict;

/*==============================================================*/
/* Table: dict                                                  */
/*==============================================================*/
create table dict
(
   id                   int not null auto_increment comment '基础字典id',
   enterprise_id        int not null default -1 comment '企业id',
   dict_name            varchar(50) not null default '' comment '字典名称',
   dict_type            int(1) not null default 1 comment '字典类型',
   dict_status          int(1) not null default 1 comment '字典状态 0-无效, 1-有效',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table dict comment '字典表';

drop table if exists dict_item;

/*==============================================================*/
/* Table: dict_item                                             */
/*==============================================================*/
create table dict_item
(
   id                   int not null auto_increment comment '字典子项id',
   enterprise_id        int not null default -1 comment '企业id',
   dict_id              int not null default -1 comment '字典id',
   item_name            varchar(100) not null comment '字典子项名称',
   item_alias           varchar(100) not null comment '字典子项别名',
   item_level           int(1) not null default 1 comment '字典子项级别',
   item_status          int(1) not null default 1 comment '字典子项 0-无效, 1-有效',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table dict_item comment '数据字典子项表';

drop table if exists post;

/*==============================================================*/
/* Table: post                                                  */
/*==============================================================*/
create table post
(
   id                   int not null auto_increment comment '岗位id',
   enterprise_id        int not null default -1 comment '企业id',
   post_name            varchar(30) not null default '' comment '岗位名称',
   is_special           int(1) not null default 0 comment '是否特殊岗位 0-否, 1-是',
   special_remark       varchar(100) not null default '' comment '特殊岗位备注',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table post comment '岗位表';

drop table if exists title;

/*==============================================================*/
/* Table: title                                                 */
/*==============================================================*/
create table title
(
   id                   int not null auto_increment comment '职务id',
   enterprise_id        int not null default -1 comment '企业id',
   title_name           varchar(50) not null default '' comment '职务名称',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table title comment '职务表';

drop table if exists user_info;

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   id                   int not null auto_increment comment '用户id',
   enterprise_id        int not null default -1 comment '企业id',
   user_account         varchar(50) not null default '' comment '用户账号',
   user_password        varchar(100) not null default '' comment '用户密码',
   user_name            varchar(50) not null default '' comment '用户名称',
   user_name_en         varchar(50) not null default '' comment '用户英文名称',
   nick_name            varchar(50) not null default '' comment '昵称',
   user_type            int(1) not null default 1 comment '用户类型, 1-手机, 2-账号',
   gender               int(1) not null default 0 comment '用户性别 0-未知, 1-男, 2-女',
   user_status          int(1) not null default 1 comment '用户状态 1-正常, 2-冻结, 3-注销',
   user_email           varchar(50) not null default '' comment '用户电子邮件',
   head_image           varchar(100) not null default '' comment ' 用户头像',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_info comment '用户信息表';

drop table if exists user_app_login;

/*==============================================================*/
/* Table: user_app_login                                        */
/*==============================================================*/
create table user_app_login
(
   id                   int not null auto_increment comment '用户应用登录id',
   user_id              int not null default -1 comment '用户id',
   first_login          int(1) not null default 0 comment '是否首次登录 0-是, 1-否',
   login_count          int not null default 0 comment '登录次数',
   last_pass_time       datetime not null comment '密码过期时间',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_app_login comment '用户应用登录表';

drop table if exists user_app_login_log;

/*==============================================================*/
/* Table: user_app_login_log                                    */
/*==============================================================*/
create table user_app_login_log
(
   id                   bigint not null auto_increment comment '用户应用登录日志id',
   user_id              int not null default -1 comment '用户id',
   user_account         varchar(50) not null default '' comment '用户账号',
   user_name            varchar(50) not null default '' comment '用户名称',
   user_name_en         varchar(50) not null default '' comment '用户英文名称',
   login_type           int(1) not null default 1 comment '登录类型 1-登录, 2-退出',
   login_time           datetime not null comment '注册或登录时间',
   log_type             int(1) not null default 1 comment '日志类型 1-app, 2-微信公众号, 3-支付宝',
   login_ip             varchar(20) not null default '' comment '登录ip',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_app_login_log comment '用户应用登录日志表';

drop table if exists user_admin;

/*==============================================================*/
/* Table: user_admin                                            */
/*==============================================================*/
create table user_admin
(
   id                   int not null auto_increment comment '用户管理id',
   enterprise_id        int not null default -1 comment '企业id',
   user_id              int not null default -1 comment '用户id',
   admin_name           varchar(30) not null default '' comment '管理名称',
   admin_type           int(1) not null default 0 comment '管理类型 1-主管理员, 2-子管理员, 3-负责人, 4-主管',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   sort                 int not null default 1 comment '排序号',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_admin comment '用户管理表';

drop table if exists user_admin_login;

/*==============================================================*/
/* Table: user_admin_login                                      */
/*==============================================================*/
create table user_admin_login
(
   id                   int not null auto_increment comment '用户管理后台登录id',
   user_id              int not null default -1 comment '用户id',
   first_login          int(1) not null default 0 comment '是否首次登录 0-是, 1-否',
   login_count          int not null default 0 comment '登录次数',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_admin_login comment '用户管理登录表';

drop table if exists user_admin_login_log;

/*==============================================================*/
/* Table: user_admin_login_log                                  */
/*==============================================================*/
create table user_admin_login_log
(
   id                   bigint not null auto_increment comment '用户登录日志id',
   user_id              int not null default -1 comment '用户id',
   user_account         varchar(50) not null default '' comment '用户账号',
   user_name            varchar(50) not null default '' comment '用户名称',
   user_name_en         varchar(50) not null default '' comment '用户英文名称',
   login_type           int(1) not null default 1 comment '登录类型 1-登录, 2-退出',
   login_time           datetime not null comment '注册或登录时间',
   log_type             int(1) not null default 1 comment '日志类型 1-pc, 2-app',
   login_ip             varchar(20) not null default '' comment '登录ip',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_admin_login_log comment '用户管理日志表';

drop table if exists user_org;

/*==============================================================*/
/* Table: user_org                                              */
/*==============================================================*/
create table user_org
(
   id                   int not null auto_increment comment '用户机构id',
   user_id              int not null default -1 comment '用户id',
   org_id               int not null default -1 comment '机构id',
   created              varchar(30) not null default '' comment '创建人',
   updated              varchar(30) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_org comment '用户机构表';

drop table if exists user_post;

/*==============================================================*/
/* Table: user_post                                             */
/*==============================================================*/
create table user_post
(
   id                   int not null auto_increment comment '用户岗位id',
   user_id              int not null default -1 comment '用户id',
   post_id              int not null default -1 comment '岗位id',
   created              varchar(30) not null default '' comment '创建人',
   updated              varchar(30) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_post comment '用户岗位表';

drop table if exists user_title;

/*==============================================================*/
/* Table: user_title                                            */
/*==============================================================*/
create table user_title
(
   id                   int not null auto_increment comment '用户职务id',
   user_id              int not null default -1 comment '用户id',
   post_id              int not null default -1 comment '岗位id',
   created              varchar(30) not null default '' comment '创建人',
   updated              varchar(30) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_title comment '用户职务表';

drop table if exists quality;

/*==============================================================*/
/* Table: quality                                               */
/*==============================================================*/
create table quality
(
   id                   int not null auto_increment comment '资质id',
   quality_name         varchar(100) not null default '' comment '资质名称',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table quality comment '资质表';

drop table if exists enterprise_quality;

/*==============================================================*/
/* Table: enterprise_quality                                    */
/*==============================================================*/
create table enterprise_quality
(
   id                   int not null auto_increment comment '企业资质id',
   enterprise_id        int not null default -1 comment '企业id',
   quality_id           int not null default -1 comment '资质id',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table enterprise_quality comment '企业资质表';

drop table if exists user_quality;

/*==============================================================*/
/* Table: user_quality                                          */
/*==============================================================*/
create table user_quality
(
   id                   int not null auto_increment comment '用户职务id',
   user_id              int not null default -1 comment '用户id',
   quality_id           int not null default -1 comment '资质id',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table user_quality comment '用户资质表';

drop table if exists attachment;

/*==============================================================*/
/* Table: attachment                                            */
/*==============================================================*/
create table attachment
(
   id                   int not null auto_increment comment '附件id',
   attachment_url       varchar(100) not null default '' comment '附件URL',
   attachment_type      int(1) not null default 1 comment '附件类型 1-图片, 2-word, 3-pdf',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table attachment comment '附件表';


drop table if exists post_attachment;

/*==============================================================*/
/* Table: post_attachment                                       */
/*==============================================================*/
create table post_attachment
(
   id                   int not null auto_increment comment '岗位附件id',
   post_id              int not null default -1 comment '岗位id',
   attachment_id        int not null default -1 comment '资质id',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table post_attachment comment '岗位附件表';

drop table if exists quality_attachment;

/*==============================================================*/
/* Table: quality_attachment                                    */
/*==============================================================*/
create table quality_attachment
(
   id                   int not null auto_increment comment '资质附件id',
   quality_id           int not null default -1 comment '资质id',
   attachment_id        int not null default -1 comment '附件id',
   is_delete            int(1) not null default 0 comment '删除标识 0-未删除, 1-已删除',
   remark               varchar(200) not null default '' comment '备注',
   created              varchar(50) not null default '' comment '创建人',
   updated              varchar(50) not null default '' comment '更新人',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table quality_attachment comment '资质附件表';







/********************** weiyong end 20181025 *******************************/

/********************** weiyong start 20190104 *******************************/
/**** 用户脚本 ***/
insert into base_user(id,user_account,user_password,user_name,create_time,update_time) 
values(1, 'admin', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '系统管理员', now(), now());
/**** 用户脚本 ***/

/**** 角色脚本 ***/
insert into base_role(id,role_name,create_time,update_time) values(1, '系统管理员', now(), now());
/**** 角色脚本 ***/

/**** 用户角色脚本 ***/
insert into base_user_role(id,base_user_id,base_role_id) values(1, 1, 1);
/**** 用户角色脚本 ***/

/**** 菜单脚本  ***/
insert into base_menu(id,parent_base_menu_id,menu_code,menu_name,parent_menu_name,menu_url,menu_level,create_time,update_time) 
values(1, -1, 'sysconfig','系统设置', '', '', 0, now(), now());
insert into base_menu(id,parent_base_menu_id,menu_code,menu_name,parent_menu_name,menu_url,menu_level,create_time,update_time) 
values(2, 1, 'sysManage','系统管理', '系统设置', '', 1, now(), now());
insert into base_menu(id,parent_base_menu_id,menu_code,menu_name,parent_menu_name,menu_url,menu_level,create_time,update_time) 
values(3, 2, 'userManage','用户管理', '系统管理', 'http://test.service.azurenet.cn:9030/base/user/getUserList', 2, now(), now());
insert into base_menu(id,parent_base_menu_id,menu_code,menu_name,parent_menu_name,menu_url,menu_level,create_time,update_time) 
values(4, 2, 'roleManage','角色管理', '系统管理', 'http://test.service.azurenet.cn:9030/base/role/getRoleList', 2, now(), now());
insert into base_menu(id,parent_base_menu_id,menu_code,menu_name,parent_menu_name,menu_url,menu_level,create_time,update_time) 
values(5, 2, 'menuManage','菜单管理', '系统管理', 'http://test.service.azurenet.cn:9030/base/menu/getMenuList', 2, now(), now());
insert into base_menu(id,parent_base_menu_id,menu_code,menu_name,parent_menu_name,menu_url,menu_level,create_time,update_time) 
values(6, 2, 'userLoginLogManage','用户登录日志管理', '系统管理', 'http://test.service.azurenet.cn:9030/base/baseUserLoginLog/getUserLoginLogList', 2, now(), now());
/**** 菜单脚本  ***/

/**** 角色菜单脚本  ***/
insert into base_role_menu(id,base_menu_id,base_role_id) values(1, 1, 1);
insert into base_role_menu(id,base_menu_id,base_role_id) values(2, 2, 1);
insert into base_role_menu(id,base_menu_id,base_role_id) values(3, 3, 1);
insert into base_role_menu(id,base_menu_id,base_role_id) values(4, 4, 1);
insert into base_role_menu(id,base_menu_id,base_role_id) values(5, 5, 1);
insert into base_role_menu(id,base_menu_id,base_role_id) values(6, 6, 1);
/**** 角色菜单脚本  ***/
/**** 系统管理  ***/
/********************** weiyong end 20190104 *******************************/
