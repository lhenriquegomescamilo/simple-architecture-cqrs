create table tb_product
(
    id         int8         not null generated by default as identity,
    name       varchar(255) not null,
    product_id varchar(36)  not null,
    price      decimal      not null,
    quantity   int4         not null

);