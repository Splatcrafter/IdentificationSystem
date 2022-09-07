# Identification-System

Identification System is a Minecraft-Spigot Plugin for identifying players with temporary ID's.

## Installation

Drag and Drop the .jar file (Included in the .zip) into your Spigot-Plugins folder (./plugins) and start your server!

## API-Usage

Dependency:
```xml
        <dependency>
            <groupId>de.splatgames.identification</groupId>
            <artifactId>identificationsystem</artifactId>
            <version>1.0.0</version>
            <scope>system</scope>
            <systemPath>${project.basedir}/libs/IdentificationSystem.jar</systemPath>
        </dependency>
```

Main-Class:
```java
package YourPackage;

import de.splatgames.identification.api.Identification;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class yourMainClass extends JavaPlugin {

    private static Identification ident;

    @Override
    public void onEnable() {
        ident = new Identification();

        //your code...
        getCommand("CommandName").setExecutor(new yourCommand(this));
        Bukkit.getPluginManager().registerEvents(new yourListener(this));
    }

    @Override
    public void onDisable() {
        //your code...
    }

    public Identification getIdent() {
        return ident;
    }
}
```

CMD-Class:
```java
package YourPackage;

import YourPackage.yourMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class yourCMD implements CommandExecutor {

    private yourMainClass main;

    public yourCMD(yourMainClass main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

            player.sendMessage("§6Deine Server ID: §7" + main.getIdent().getID(player));
            
        return false;
    }
}
```
