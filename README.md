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