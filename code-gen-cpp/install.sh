#!/bin/bash - 
#===============================================================================
#
#          FILE: install.sh
# 
#         USAGE: ./install.sh 
# 
#   DESCRIPTION: 
# 
#       OPTIONS: ---
#  REQUIREMENTS: ---
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: YOUR NAME (), 
#  ORGANIZATION: 
#       CREATED: 02/04/2016 16:50
#      REVISION:  ---
#===============================================================================

set -o nounset                              # Treat unset variables as an error
cd ./ctemplate \
    && ./configure \
    && make \
    && make install

