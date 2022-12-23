
.PHONY: help clean build check-versions

DATE=`date +'%F'`
NAME=`xmllint --xpath "//project/artifactId/text()" pom.xml`
VERSION=`xmllint --xpath "//project/version/text()" pom.xml`
PREVIOUS_TAG=`git tag | sort -r | head -n 1`

help:
	@echo "Available targets for $(NAME):"
	@echo "\thelp\t\t\tThis help"
	@echo "\tclean\t\t\tDelete everything in ./target"
	@echo "\tbuild\t\t\tCleans the project and rebuilds the code"
	@echo "\tcheck-versions\t\tCheck if the versions of dependencies are up to date"
	@echo "\trelease-notes\t\tCreate release notes for the latest version"

clean:
	@echo "[$(NAME)] Cleaning"
	@mvn -Dorg.slf4j.simpleLogger.defaultLogLevel=warn clean

build:
	@echo "[$(NAME)] Building"
	@mvn -Dorg.slf4j.simpleLogger.defaultLogLevel=warn -DskipTests=true clean package

check-versions:
	@mvn versions:display-dependency-updates
	@mvn versions:display-plugin-updates
