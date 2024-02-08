Clear the <INITIAL_ADMIN> environment variable.
Open your shell profile using a command line text editor.
pico ~/.bash_profile
Replace the content of the file with the following lines.
export HYBRIS_HOME_DIR=/opt/CXCOMM210500P_X-XXXXXXXX
export ANT_HOME=${HYBRIS_HOME_DIR}/hybris/bin/platform/apache-ant
export PATH=${PATH}:${ANT_HOME}/bin
