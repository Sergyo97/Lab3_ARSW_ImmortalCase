
# Immortals Case Laboratory


### Part I -  Producer/Consumer
1. Debido a que el hilo consumidor esta constantemente verificando la lista para consumir, esa verificación consume recursos por lo que se debe implementar un mecanismo que solo consuma cuando haya algo que consumir.
2. El mecanismo implementado es que el productor le avise al consumidor que produjo algo, de igual forma también se implemento que cuando el productor produjera hasta un tope, el consumidor le avisa que consumió por lo que podrá producir

### Part II
 - El valor de la invariante para la suma de puntos de vida para N Immortals es de N * 100.
 - Design
 
	 - Pause implementation
	
	![enter image description here](https://lh3.googleusercontent.com/Zq-0YMLbA9rKL0vZEgYN9MS9ZFc1MigldAssG49S4kedhOlyuRGqgxZCOMhSTlqzbkWge_X05fzp)
	 - Synchronization with Atomic types
	 
	![enter image description here](https://lh3.googleusercontent.com/iPSB1sunMC3Po_FMf50DgyRbUVk8WJ8St8CmiS8VzHPg5aYHN2Z_KdiRgJshBI86hcahydeiL1lb)
	 
	 - Synchronized fights

	![enter image description here](https://lh3.googleusercontent.com/dFhnQIgKEAAmYJJs92Hn5AU3z_EjhUbkkkElwpFFJpbdS9XOfL9mdMbMNqcQ0AT6mxQWl1o8fi61)

	 - Concurrent collections
 
	![enter image description here](https://lh3.googleusercontent.com/tyE4a9MVjsXLd8pdUptBH1BDn-2NbL2gwlNdFs5_PfONc8wDFf_SlqmCv7N--qQ0BwdY52M6wGkX)



## Running

Compile first time the project after downloaded.

    mvn package
    
To run the whole project.

    mvn exec:java -D exec.mainClass="edu.eci.arsw.highlandersim.ControlFrame"
Generate documentation

    mvn javadoc:jar

## Authors
Michael Sebastián Preciado Garzón - Escuela Colombiana de Ingeniería Julio Garavito

Sergio Hernando Ruiz Paez - Escuela Colombiana de Ingeniería Julio Garavito

## License
This project is under GNU General Public License - see  [LICENSE](https://github.com/Sergyo97/Lab3_ARSW_ImmortalCase/blob/master/LICENSE) to more info.