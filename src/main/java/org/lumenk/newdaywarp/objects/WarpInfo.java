package org.lumenk.newdaywarp.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class WarpInfo {

    @NotNull
    private String departureRegionName;

    @NotNull
    private Location arrivalLocation;

}
