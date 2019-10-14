CREATE TABLE app.posts (
  post_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
  postname VARCHAR(50),
  comments VARCHAR(512) NOT NULL
 );
 
 INSERT INTO app.posts(postname, comments) VALUES('Fred Jones', 
   'Derby is cool, and the Eclipse plugin makes using it a snap!');
INSERT INTO app.posts(postname, comments) VALUES('Wilma Harris', 
   'Tomcat lets me register DataSources using a file in my web project? That''s great stuff!');