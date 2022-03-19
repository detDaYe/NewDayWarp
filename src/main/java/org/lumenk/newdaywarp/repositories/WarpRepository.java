package org.lumenk.newdaywarp.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.lumenk.newdaywarp.objects.WarpInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class WarpRepository {

    private static final String PLUGIN_PATH = "plugins/NewDayWarps";
    private static final String FILE_NAME = "data.json";
    private static final HashMap<String, WarpInfo> warpInfoMap = new HashMap<>();


    @NotNull
    public static WarpInfo getWarp(@NotNull String departureRegion){
        return warpInfoMap.getOrDefault(departureRegion, null);
    }

    public static void setWarp(@NotNull WarpInfo warpInfo){
        warpInfoMap.put(warpInfo.getDepartureRegionName(), warpInfo);
    }

    public static void save(){
        final String FILE_PATH = PLUGIN_PATH + "/" + FILE_NAME;
        Set<String> departureRegionsNames = warpInfoMap.keySet();

        ArrayList<WarpInfo> warpList = new ArrayList<>();

        for(String s : departureRegionsNames){
            warpList.add(Objects.requireNonNull(getWarp(s)));
        }

        WarpInfo[] warps = warpList.toArray(new WarpInfo[0]);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(warps);
        //Bukkit.getLogger().info(json);
        try {
            Files.writeString(Path.of(FILE_PATH), json, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace(); //분명히 create 시켰는데 에러나면 안되는겁니다. 아마...도..
        }

    }

    public static void load(){
        warpInfoMap.clear();
        String json = "[]";
        final String FILE_PATH = PLUGIN_PATH + "/" + FILE_NAME;
        try {
            json = Files.readString(Path.of(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();


            File dir = new File(PLUGIN_PATH);
            dir.mkdirs();
        }

        Gson gson = new Gson();
        WarpInfo[] warpInfoArray = gson.fromJson(json, WarpInfo[].class);
        for(int i = 0; i < warpInfoArray.length; i++)
            setWarp(warpInfoArray[i]);



    }
}
