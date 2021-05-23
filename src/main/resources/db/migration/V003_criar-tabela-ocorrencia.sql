create table ocorrencia (
    id bigint not null,
    entraga_id bigint not null,
    descricao text not null,
    data_registro datetime not null,

    primary key (id)
);

alter table ocorrencia add contraint fk_ocorrencia_entrega
foreign key (entrega_id) references entrega (id);