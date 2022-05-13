create table timecard_mgmt.location
(
    id varchar(255) not null primary key
);

create table timecard_mgmt.effort
(
    id varchar(255) not null primary key,
    date datetime(6) not null ,
    hours int not null ,
    billable boolean not null,
    note varchar(255),
    location_id varchar(255) not null ,
    FOREIGN KEY (location_id) REFERENCES timecard_mgmt.location(id)
);

