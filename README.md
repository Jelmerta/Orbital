# Orbital
#### Detecting orbiters of a certain gnome
This program will figure out which orbiters are currently in Destiny's voice channel and return this on an endpoint as a list of strings.

### Running project
* Make sure to configure the Discord bot token found in OrbiterManager to one with read permissions in the Discord.
* Either run ./mvnw spring-boot:run or just run the main function.
* Go to localhost:8080/orbiters/ to see a list of the current orbiters found in Destiny's voice channel.

#### Notes
* A number of orbiters have been added, but this list will likely change.
* We made sure that the orbiter names are identical to the ones found in Manifold Markets, for easier comparison 