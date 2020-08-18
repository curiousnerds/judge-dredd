# judge-dredd
> build the project

> remove existing docker image
 docker rmi -f java-judge:1.0.0

> run build docker image

> docker build -t java-judge:1.0.0 .

Run the following

> docker run -it --rm -v $PWD:/tests -w /tests --privileged java-judge:1.0.0 bash

go to java-judge
cd /usr/local/java-judge

java -cp /usr/local/java-libs/*:. com.curiousnerds.judge.Work


MYSQL experiment notes; 

> Set up docker instance with a mysql server running. 
> the docker instance could be shared with other instances, make the mysql server running in background. 
> mysql -u [username] -p [dbname] -e [query] > [somefilename] this is how you get the data to a file 

 docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_USER=dinda  -e MYSQL_PASSWORD=dinda  -e MYSQL_DATABASE=dinda -d java-judge:1.0.0

 docker exec -it some-mysql bash

 mysql -u dinda -p dinda -e select * from employee;  > sometext.txt
mysql -u dinda -pdinda dinda -s -e "select * from employe;" >> out.txt  2>err.txt ; // with out.txt and err.txt; // added -s to remove the header  // -t to show in table format 

export MYSQL_PWD=dinda ;mysql -u dinda  dinda -s -e "select * from employe;" >> out.txt  2>err.txt ; // solves the mysql warning on the err file , about the password being passed from comand line 


// Test cases ; 

A multiline and the error text should honor the multiline;

export MYSQL_PWD=dinda ;mysql -u dinda  dinda -s -e "select 
* from *
employe;" >> out.txt  2>err.txt  