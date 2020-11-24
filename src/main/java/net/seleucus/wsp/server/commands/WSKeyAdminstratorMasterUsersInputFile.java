package net.seleucus.wsp.server.commands;

import net.seleucus.wsp.server.WSServer;
import org.hsqldb.util.CSVWriter;

import java.io.*;

public class WSKeyAdminstratorMasterUsersInputFile extends WSCommandOption {

	public WSKeyAdminstratorMasterUsersInputFile(WSServer myServer) {
		super(myServer);
	}

	@Override
	protected void execute() {

		final String users = this.myServer.getWSDatabase().users.showAllUsers();
		myServer.println(users);
		
		final int ppID = myServer.readLineOptionalInt("Select a User ID");
		final boolean userIDFound = myServer.getWSDatabase().passPhrases.isPPIDInUse(ppID);
		
		if(userIDFound == false) {
			
			myServer.println("User ID Not Found");

		} else {
			

			
		}
		
	} // execute method

	@Override
	public boolean handle(String cmd) {

		boolean validCommand = false;

		if(isValid(cmd)) {
			validCommand = true;
			this.execute();
		}
		
		return validCommand;
		
	} // handle method

	@Override
	protected boolean isValid(String cmd) {
		
		boolean valid = false;
		
		if(cmd.equalsIgnoreCase("user save")) {
			
			valid = true;
		
		}
		
		return valid;
		
	}  // isValid method

	public static void writeDataLineByLine(String filePath) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("keyAdminstratorPINFil.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		String columnNamesList = "Id,usernames";
		builder.append(columnNamesList +"\n");
		builder.append("1"+",");
		builder.append("Chola");
		builder.append('\n');
		pw.write(builder.toString());
		pw.close();
	}

}
