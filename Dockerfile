FROM ubuntu:latest
RUN apt-get -y update
RUN apt-get -y install firefox
RUN apt-get -y install xauth
RUN apt install -y default-jre
RUN apt install -y default-jdk
EXPOSE 8887
COPY . /javamon
#ENTRYPOINT "/javamon"
#CMD ["javac *.java"]
#CMD ["java Driver"]
