This is a simple config options from XML

Built in IntelliJ IDEA 2018.3

This is a self contained project to populate a CoeusConfig class with values from an XML file.

I chose the name CoeusConfig to avoid conflict with any other 'Config' classes that you might use.

Example usage: I use this to store some settings that change for various reasons. The Database server -for when I need
to change the datasource without having to rebuild the project. 

DeBug setting - so I can turn this on an off while the project is running to get deBug info output at a specific time



This class will load from an XML file. If the file doesn't exists, it will create a new one.