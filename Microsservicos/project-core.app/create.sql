create table atividade (id bigint not null, associate_id bigint, status_id bigint, primary key (id))
create table fase (id bigint not null, project_id bigint, status_id bigint, primary key (id))
create table fase_activities (phase_entity_id bigint not null, activities_id bigint not null)
create table projeto (id bigint not null, inicio timestamp, cor varchar(255), descricao varchar(255), fim timestamp, identificacao varchar(255), manager_id bigint, status_id bigint, primary key (id))
create table projeto_associates (project_entity_id bigint not null, associates_id bigint not null)
create table role (id bigint not null, descricao varchar(255), primary key (id))
create table status (id bigint not null, descricao varchar(255), primary key (id))
create table usuario (id bigint not null, codigo varchar(255), email varchar(255), nome varchar(255), role_id bigint, primary key (id))
alter table fase_activities add constraint UK_p1ld0oyhb9q413u38p0qnwnq2 unique (activities_id)
alter table projeto_associates add constraint UK_16r5kcwq6eecgm2ncy4wqtyya unique (associates_id)
alter table atividade add constraint FKp5l1o57ho14myrnxb8mx72xuh foreign key (associate_id) references usuario
alter table atividade add constraint FKakqrt6x3flpq26etic8g1s21n foreign key (status_id) references status
alter table fase add constraint FKhix8eaksgjkhoi7mj9kbxpx55 foreign key (project_id) references projeto
alter table fase add constraint FKcw0v32j3m3ft8l1g0hpwpn34w foreign key (status_id) references status
alter table fase_activities add constraint FK7oeu79k1wtt54bb9gw4dd6vk8 foreign key (activities_id) references atividade
alter table fase_activities add constraint FK8m3gjhxmj65ftp1or8n5gform foreign key (phase_entity_id) references fase
alter table projeto add constraint FK8yvtjoi0108ptkc625i5x8kjo foreign key (manager_id) references usuario
alter table projeto add constraint FK3cg6rscgjvk4cvhthjx62se2f foreign key (status_id) references status
alter table projeto_associates add constraint FKgkx7v7h3l0v7qssoofav84kh5 foreign key (associates_id) references usuario
alter table projeto_associates add constraint FKg8nya3ymfttgsqyi9dcw2fhxj foreign key (project_entity_id) references projeto
alter table usuario add constraint FK3qieopaxyoowdge29v1m51wr9 foreign key (role_id) references role
create table atividade (id bigint not null, associate_id bigint, status_id bigint, primary key (id))
create table fase (id bigint not null, project_id bigint, status_id bigint, primary key (id))
create table fase_activities (phase_entity_id bigint not null, activities_id bigint not null)
create table projeto (id bigint not null, inicio timestamp, cor varchar(255), descricao varchar(255), fim timestamp, identificacao varchar(255), manager_id bigint, status_id bigint, primary key (id))
create table projeto_associates (project_entity_id bigint not null, associates_id bigint not null)
create table role (id bigint not null, descricao varchar(255), primary key (id))
create table status (id bigint not null, descricao varchar(255), primary key (id))
create table usuario (id bigint not null, codigo varchar(255), email varchar(255), nome varchar(255), role_id bigint, primary key (id))
alter table fase_activities add constraint UK_p1ld0oyhb9q413u38p0qnwnq2 unique (activities_id)
alter table projeto_associates add constraint UK_16r5kcwq6eecgm2ncy4wqtyya unique (associates_id)
alter table atividade add constraint FKp5l1o57ho14myrnxb8mx72xuh foreign key (associate_id) references usuario
alter table atividade add constraint FKakqrt6x3flpq26etic8g1s21n foreign key (status_id) references status
alter table fase add constraint FKhix8eaksgjkhoi7mj9kbxpx55 foreign key (project_id) references projeto
alter table fase add constraint FKcw0v32j3m3ft8l1g0hpwpn34w foreign key (status_id) references status
alter table fase_activities add constraint FK7oeu79k1wtt54bb9gw4dd6vk8 foreign key (activities_id) references atividade
alter table fase_activities add constraint FK8m3gjhxmj65ftp1or8n5gform foreign key (phase_entity_id) references fase
alter table projeto add constraint FK8yvtjoi0108ptkc625i5x8kjo foreign key (manager_id) references usuario
alter table projeto add constraint FK3cg6rscgjvk4cvhthjx62se2f foreign key (status_id) references status
alter table projeto_associates add constraint FKgkx7v7h3l0v7qssoofav84kh5 foreign key (associates_id) references usuario
alter table projeto_associates add constraint FKg8nya3ymfttgsqyi9dcw2fhxj foreign key (project_entity_id) references projeto
alter table usuario add constraint FK3qieopaxyoowdge29v1m51wr9 foreign key (role_id) references role
create table atividade (id bigint not null, inicio timestamp, cor varchar(255), descricao varchar(255), fim timestamp, associate_id bigint, project_id bigint, status_id bigint, primary key (id))
create table fase (id bigint not null, inicio timestamp, cor varchar(255), fim timestamp, sequencia bigint, phase_type_id bigint, project_id bigint, status_id bigint, primary key (id))
create table fase_activities (phase_entity_id bigint not null, activities_id bigint not null)
create table projeto (id bigint not null, inicio timestamp, cor varchar(255), descricao varchar(255), fim timestamp, identificacao varchar(255), manager_id bigint, status_id bigint, primary key (id))
create table projeto_associates (project_entity_id bigint not null, associates_id bigint not null)
create table role (id bigint not null, descricao varchar(255), primary key (id))
create table status (id bigint not null, descricao varchar(255), primary key (id))
create table tipofase (id bigint not null, descricao varchar(255), primary key (id))
create table usuario (id bigint not null, codigo varchar(255), email varchar(255), nome varchar(255), role_id bigint, primary key (id))
alter table fase_activities add constraint UK_p1ld0oyhb9q413u38p0qnwnq2 unique (activities_id)
alter table projeto_associates add constraint UK_16r5kcwq6eecgm2ncy4wqtyya unique (associates_id)
alter table atividade add constraint FKp5l1o57ho14myrnxb8mx72xuh foreign key (associate_id) references usuario
alter table atividade add constraint FKfskthx8bs07q7e7qmq5yagiqa foreign key (project_id) references projeto
alter table atividade add constraint FKakqrt6x3flpq26etic8g1s21n foreign key (status_id) references status
alter table fase add constraint FKp7bunh5vksyxsptq3j5va7i9h foreign key (phase_type_id) references tipofase
alter table fase add constraint FKhix8eaksgjkhoi7mj9kbxpx55 foreign key (project_id) references projeto
alter table fase add constraint FKcw0v32j3m3ft8l1g0hpwpn34w foreign key (status_id) references status
alter table fase_activities add constraint FK7oeu79k1wtt54bb9gw4dd6vk8 foreign key (activities_id) references atividade
alter table fase_activities add constraint FK8m3gjhxmj65ftp1or8n5gform foreign key (phase_entity_id) references fase
alter table projeto add constraint FK8yvtjoi0108ptkc625i5x8kjo foreign key (manager_id) references usuario
alter table projeto add constraint FK3cg6rscgjvk4cvhthjx62se2f foreign key (status_id) references status
alter table projeto_associates add constraint FKgkx7v7h3l0v7qssoofav84kh5 foreign key (associates_id) references usuario
alter table projeto_associates add constraint FKg8nya3ymfttgsqyi9dcw2fhxj foreign key (project_entity_id) references projeto
alter table usuario add constraint FK3qieopaxyoowdge29v1m51wr9 foreign key (role_id) references role
