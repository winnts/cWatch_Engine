#!/usr/bin/env bash

i=1
for i in {1..2000}
do
    wget -O /dev/null -o /dev/null http://io-sol.com/?malvare=curl
    wget -O /dev/null -o /dev/null http://coolkodi.com/?malvare=curl
    wget -O /dev/null -o /dev/null http://global-8000.com/?malvare=curl
done
