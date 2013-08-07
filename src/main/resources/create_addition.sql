CREATE SEQUENCE addition_seq;
CREATE TABLE addition
(
	id integer not null default nextval('addition_seq') PRIMARY KEY,
	x double precision NOT NULL,
	y double precision NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE addition
  OWNER TO postgres;