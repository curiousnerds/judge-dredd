#  Judge-Dredd
             
             
             
             Process: 
              first build the language pack by building 
             >  docker build -t curiousnerds/languagepack:1.0.0 . 
             If you want to have mysql 8 then build as 
             >  docker build -t curiousnerds/mysql-8:1.0.0 . -f Dockerfile.mysql
                 You can test the application by  
             >       docker run -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_USER=dinda  -e MYSQL_PASSWORD=dinda  -e MYSQL_DATABASE=dinda -d curiousnerds/mysql-8:1.0.0
             
             
             
             Trying to build a complete new images 
             
                 `docker build -t curiousnerds/languagepack:1.0.0 . `
                 
             Once build done , try run it , pass in mysql related paramters, make sure to pass in --previledged to docker run to make isolate work properly.
                 
                 ` docker run \
                 --privileged \
                 -v $PWD:/tests -w /tests \
                 -e MYSQL_ROOT_PASSWORD=my-secret-pw \
                 -e MYSQL_USER=dinda   \
                 -e MYSQL_PASSWORD=dinda  \
                 -e MYSQL_DATABASE=dinda \
                 -d curiousnerds/languagepack:1.0.0`
             
             Additionally you can use `-v $PWD:/tests -w /tests` if you want to modify tests or add test ( typically in dev or debugging situations)
                 
                 
             The above run will generate a hash is the container id , you need in the next command. Container id , is possibly
             a good indication if the image ran successfully. Now our Job is the test if the language supported is working fine. You could have executed the same
             in the above command,but the following command will let you go inside the container and execute the tests.
                 
             ` docker exec -it <container id here > bash`
             
             Once you are in the container , you can cd to the tests folder.
             
             `./run ` // if you wish to run all the languages without isolate
             
             `./run --isolate`  // if you wish to run all the isllanguage in isolate 
             
             `./run --language <language_foldername> ` // If you want to run specific language , with or without isolate by appending/not  --isolate
             
             
             
             ## Few notes 
              build the project
             
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
             
              docker run -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_USER=dinda  -e MYSQL_PASSWORD=dinda  -e MYSQL_DATABASE=dinda -d java-judge:1.0.0
             
              docker exec -it some-mysql bash
             
              mysql -u dinda -p dinda -e select * from employee;  > sometext.txt
             mysql -u dinda -pdinda dinda -s -e "select * from employe;" >> out.txt  2>err.txt ; // with out.txt and err.txt; // added -s to remove the header  // -t to show in table format 
             
             export MYSQL_PWD=dinda ;mysql -u dinda  dinda -s -e "select * from employe;" >> out.txt  2>err.txt ; // solves the mysql warning on the err file , about the password being passed from comand line 
             
             
             // Test cases ; 
             
             A multiline and the error text should honor the multiline;
             
             export MYSQL_PWD=dinda ;mysql -u dinda  dinda -s -e "select 
             * from *
             employe;" >> out.txt  2>err.txt  
             
             
Some steps for mac.
===================
This will produce the linux/amd64 and linux/arm64 version of builds simultanegously

docker buildx build --platform linux/amd64,linux/arm64 -t curiousnerds/languagepack-mac:1.0.0 .

In the recent docker versions the cgroupv2 is added, which is not compatible
for isolate which uses cgroupv1. 
But in docker we can change the settings to fallback to cgroupv1 
by changing it in the 
/Users/<name>/Library/Group \ Containers/group.com.docker/settings.json
"deprecatedCgroupv1": true. 

A newer version of the isolate is on progress which makes use of the cgroupv2 version
keep following to github.com/ioi/isolate  for more information on the github.com/ioi/isolate/issues/78

#####
Read about making architectural independent docker image in Dockerfile.
https://nielscautaerts.xyz/making-dockerfiles-architecture-independent.html

Basically there are two ways you can do the build 

Building and keeping the image locally 
---------
docker build --platform linux/arm64 -t  <tag> . 
docker build --platform linux/amd64 -t -<tag> .

Building and keeping the image on docker registry 
---------
The below way has advantage which can build the image for multiple platforms 
but you will have to push the image to the registry ( for registry you must sign up/in to docker registry)
pushing the image takes a longtime, thus this must be the very last stage after you verified using the 
above method ( keeping image locally)
//TODO: The version strategy needs to be done
docker buildx build --platform linux/amd64,linux/arm64  --push -t aneonoir/judge-dredd:v1.0.0 . 

currently the repository name is aneonoir/judge-dredd,this image is PUBLIC  we can change the name later on 

REMEMBER 
============
If you are using the docker registry method always pull the image the image locally won't 
refresh unless you download/pull it from registry 
// Replace your version number later on 
`docker pull aneonoir/judge-dredd:v1.0.0`

if you ever face problem related to the worker directory is not able to be created , make sure the cggroup is enabled
"deprecatedCgroupv1": true. see above 

Running on Mac  M1 using --platform linux/amd64 is very slow
docker run --privileged -v $PWD:/tests -w /tests -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_USER=dinda   -e MYSQL_PASSWORD=dinda  -e MYSQL_DATABASE=dinda -d curiousnerds/languagepack:1.0.0`

TOUBLESHOOTING: 
if you get a error like `bash: ./run: /bin/bash^M: bad interpreter: No such file or directory while running  your run --language --isolate 

then run the following command in the  command prompt 
sed -i 's/\r$//' run 
