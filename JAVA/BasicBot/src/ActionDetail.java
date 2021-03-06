import bwapi.Position;
import bwapi.UnitType;

public class ActionDetail {
    private String command;
    private Unit2 srcUnit;
    private Unit2 destUnit;
    private UnitType unitType;
    private Position position;
    private int actionFrame;
    private int margin;

    public ActionDetail(String command, Unit2 srcUnit, Unit2 destUnit, UnitType unitType, Position position, int actionFrame, int margin) {
	this.command = command;
	this.srcUnit = srcUnit;
	this.destUnit = destUnit;
	this.unitType = unitType;
	this.position = position;
	this.actionFrame = actionFrame;
	this.margin = margin;
    }

    public String getCommand() {
	return command;
    }

    public Unit2 getSrcUnit() {
	return srcUnit;
    }

    public Unit2 getDestUnit() {
	return destUnit;
    }

    public UnitType getUnitType() {
	return unitType;
    }

    public Position getPosition() {
	return position;
    }

    public int getActionFrame() {
	return actionFrame;
    }

    public int getMargin() {
	return margin;
    }

    @Override
    public boolean equals(Object obj) {
	boolean result = false;

	if (obj instanceof ActionDetail) {
	    ActionDetail target = (ActionDetail) obj;
	    if (null != command) {
		result = command.equals(target.getCommand());
	    } else {
		result = null == target.getCommand();
	    }
	    if (true == result) {
		if (null != srcUnit) {
		    result = srcUnit.getID() == target.getSrcUnit().getID();
		} else {
		    result = null == target.getSrcUnit();
		}
	    }
	    if (true == result) {
		if (null != destUnit) {
		    result = destUnit.getID() == target.getDestUnit().getID();
		} else {
		    result = null == target.getDestUnit();
		}
	    }
	    if (true == result) {
		if (null != unitType) {
		    result = unitType.equals(target.getUnitType());
		} else {
		    result = null == target.getUnitType();
		}
	    }
	    if (true == result) {
		if (null != position) {
		    result = position.getX() == target.getPosition().getX() && position.getY() == target.getPosition().getY();
		} else {
		    result = null == target.getPosition();
		}
	    }
	    if (true == result) {
		result = margin == target.getMargin();
	    }
	}

	return result;
    }

    @Override
    public int hashCode() {
	int result = 0;

	if (null != command) {
	    result += command.hashCode();
	}

	if (null != srcUnit) {
	    result += srcUnit.getID();
	}

	if (null != destUnit) {
	    result += destUnit.getID();
	}

	if (null != unitType) {
	    result += unitType.toString().hashCode();
	}

	if (null != position) {
	    result += position.getX() + position.getY();
	}

	result += margin;

	return result;
    }

    @Override
    public String toString() {
	return "ActionDetail[command=" + command + ", srcUnit=" + (null != srcUnit ? srcUnit.getID() : "null") + ", destUnit=" + (null != destUnit ? destUnit.getID() : "null")
		+ ", unitType=" + unitType + ", position=" + position + ", actionFrame=" + actionFrame + ", margin=" + margin;
    }
}
