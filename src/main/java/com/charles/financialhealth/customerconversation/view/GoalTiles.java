package com.wellsfargo.financialhealth.customerconversation.view;



import java.util.List;

public class GoalTiles {

  private String name;
  private String imgPath;
  private int goalId;
  private List<Tile> goalTilesList;

  public String getName(){
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImgPath(){
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }

  public int getGoalId(){
    return goalId;
  }

  public void setGoalId(int goalId){
    this.goalId = goalId;
  }

  public List<Tile> getGoalTilesList(){
    return goalTilesList;
  }

  public void setGoalTilesList(List<Tile> goalTilesList){
    this.goalTilesList = goalTilesList;
  }

  public static class Tile {
  
      private int tileId;
      private String tileName;
      private String tileImg;


      public int getTileId(){
        return tileId;
      }

      public void setTileId(int tileId) {
        this.tileId = tileId;
      }

      public String getTileName(){
          return tileName;
      }

      public void setTileName(String tileName) {
        this.tileName = tileName;
      }

      public String getTileImg(){
        return tileImg;
      }
      public void setTileImg(String tileImg) {
        this.tileImg = tileImg;
      }
  }









}



