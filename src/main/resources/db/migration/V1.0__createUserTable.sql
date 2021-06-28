CREATE OR REPLACE FUNCTION "upd_timestamp"()
RETURNS TRIGGER AS $$
BEGIN
    NEW.UPDATED_AT = now();
    RETURN NEW;
END;
$$ language 'plpgsql';


CREATE TABLE userp(
   ID SERIAL PRIMARY KEY     NOT NULL,
   NAME           TEXT    NOT NULL,
   AGE            INT     NOT NULL,
   CREATED_AT TIMESTAMP WITH TIME ZONE DEFAULT now(),
   UPDATED_AT TIMESTAMP(6)
);

CREATE TRIGGER "update_trigger" BEFORE UPDATE ON "userp"
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();
insert into userp (id,name,age) values(1,'Luke',29);






