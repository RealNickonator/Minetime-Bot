package bot.commands;

import net.dv8tion.jda.events.message.MessageReceivedEvent;
import bot.Command;

public class AIQuestionCommand implements Command
{
	private final String HELP_ = "USAGE: ~!q";
	

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) 
	{
		return true;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) 
	{
		String input = "";
		for(String a : args)
		{
			input += a + " ";
		}
		
		if(input.contains("What is") || input.contains("what is") ||
				input.contains("Wat is") || input.contains("wat is") ||
				input.contains("Wut is") || input.contains("wut is") ||
				input.contains("What iz") || input.contains("what iz") ||
				input.contains("wat iz") || input.contains("wut iz"))
			{
				int a = 0;
				int b = 0;
				if(input.contains("What is"))
				{
				    a = input.indexOf("What is");
				    b = a+8;
				}
				else if(input.contains("what is"))
				{
				    a = input.indexOf("what is");
				    b = a+8;
				}
				else if(input.contains("wut is"))
				{
				    a = input.indexOf("wut is");
				    b = a+7;
				}
				else if(input.contains("wat is"))
				{
				    a = input.indexOf("wat is");
				    b = a+7;
				}
				else if(input.contains("Wut is"))
				{
				    a = input.indexOf("Wut is");
				    b = a+7;
				}
				else if(input.contains("Wat is"))
				{
				    a = input.indexOf("Wat is");
				    b = a+7;
				}

				try
				{
				    String objInQuestion = input.substring(b);
				    
				    String d = objInQuestion.replace(" ", "");
				    String whatIsObj = AI.AI.readKnowledge(d);
				    
				    if(whatIsObj == null)
				    {    
				        //System.out.println("[AI] Sorry, I do not know what " 
				        //                + objInQuestion + " is.");
				    	event.getTextChannel().sendMessage("Sorry, I do not know what " + objInQuestion + " is.");
				    }
				    else
				    {
				    	whatIsObj = whatIsObj.replace("]", "");
				        //System.out.println("[AI] My data tells " + 
				        //    "me that " + objInQuestion + " is " + whatIsObj);
				    	event.getTextChannel().sendMessage(" " + objInQuestion + " is " + whatIsObj);
				    }
				}catch(Exception e)
				{
					String objInQuestion = input.substring(b);
					//System.out.println("[AI] Sorry, I do not know what " 
				    //        + objInQuestion + " is.");
					event.getTextChannel().sendMessage("Sorry, I do not know what " + objInQuestion + " is.");
				}
			}
	}

	@Override
	public String help() 
	{
		return HELP_;
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) 
	{
		return;
	}
	
	
}

/*
*/