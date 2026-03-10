$(eval TMP := $(shell mktemp))
JAVAC = "javac"
JAVA = 'java'
SOURCE="Scanner"                   
COMPILER = "Scanner"
INP0 = "./input.txt"
OUT0 = "./output.txt"     
DIFF = "/usr/bin/diff"

all: compile
compile:
	$(JAVAC) $(COMPILER).java            

test:

			$(JAVA) $(COMPILER) $(INP0) > $(TMP)
			@if $(DIFF) $(TMP) $(OUT0); then \
				echo "(:"; \
			else \
				echo ":/"; \
			fi
