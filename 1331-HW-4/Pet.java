import java.util.*;
public class Pet {
	private String name;
	private int happiness;
	private int hunger;
	Random rand;
	public Pet(String name){
		this.name = name;
		happiness = 100;
		hunger = 0;
		
	}
	public void play(){
		if (this.happiness == 100){
			System.out.println("TOO HAPPY! GOING TO BURST RAINBOWS! >.<");
		}
		else{
			this.happiness +=10;
			System.out.println("Yay! Playtime! Happiness: " + this.happiness);
		}
	}
	public void feed(boolean treat){
		if (this.hunger ==0){
			System.out.println("Too full! I'm pregnant with food! >.<");	
		}
		else{
			if (treat==true){
				System.out.println("I love treats! More?");
				this.hunger-=10;
				this.happiness +=10;
			}
			else{
				this.hunger-=10;
				System.out.println("Yummy! More?");
			}
		}
	}
	public void live(){
		rand = new Random();
		double mood_Chance = rand.nextDouble();
		double food_Chance = rand.nextDouble();
		if (food_Chance >=.4 ){
			this.hunger+=10;
		}
		if(mood_Chance >=.6){
			this.happiness-=10;
		}
	}
	public String toString(){
		String name_Label = "Name: "+getName();
		String happiness_Label = "Happiness Level: " + (""+this.happiness);
		String hunger_Label = "Hunger Level: "+this.hunger;
		String text = name_Label + "\n" +happiness_Label + "\n" +hunger_Label + "\n"; 
		return text;
		
	}
	public String getName(){
		String getter = this.name;
		return getter;
		
	}
}
