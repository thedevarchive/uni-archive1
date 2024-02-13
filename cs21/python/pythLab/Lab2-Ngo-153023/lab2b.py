#Alyssa Mae Ngo
#153023
#August 30, 2016

"""
I hereby attest to the truth of the following facts:

I have not discussed the Python language code in my program
with anyone other than my instructor or the teaching assistants assigned to this course.

I have not used Python language code obtained from another
student, or any other unauthorized source, either modified or unmodified.

If any Python language code or documentation used in my
program was obtained from another source, such as a text book or course notes, that has
been clearly noted with a proper citation in the comments of my program.
"""

data = int(input())
count = 1
h = 0 #highest number
no1 = int(input()) #first number
l = no1 #lowest no

while count < data:
	no2 = int(input()) #second number
	if h < no2:
		h = no2
	if l > no2:
		l = no2
	count = count + 1

print('Maximum = ' + str(h))
print('Minimum = ' + str(l))
print('Range = ' + str(h - l))

# Thanks to Wesley Ong for reminding me to read the instructions
# Thanks to Kim Untal for reminding me to add str()