import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bwapi.TilePosition;

// 서킷 브레이커 맵
public class LocationManagerCircuitBreaker_FiveFactoryGoliath extends LocationManager {
    private static final int ONE_CLOCK = 0;
    private static final int FIVE_CLOCK = 1;
    private static final int SEVEN_CLOCK = 2;
    private static final int ELEVEN_CLOCK = 3;

    private StrategyManager strategyManager = null;

    @Override
    protected void onStart(GameStatus gameStatus) {
	super.onStart(gameStatus);
	strategyManager = gameStatus.getStrategyManager();
    }

    @Override
    public List<TilePosition> initBaseLocations() {

	List<TilePosition> result = new ArrayList<>(4);

	result.add(new TilePosition(117, 9)); // 1시
	result.add(new TilePosition(117, 118)); // 5시
	result.add(new TilePosition(7, 118)); // 7시
	result.add(new TilePosition(7, 9)); // 11시

	return result;
    }

    // 정찰할 위치(순서)를 설정한다.
    @Override
    public List<TilePosition> initSearchSequence() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시: 5시, 11시, 7시 순서로 정찰
	    result.add(getBaseLocations(FIVE_CLOCK));
	    result.add(getBaseLocations(ELEVEN_CLOCK));
	    result.add(getBaseLocations(SEVEN_CLOCK));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시: 7시, 1시, 11시 순서로 정찰
	    result.add(getBaseLocations(SEVEN_CLOCK));
	    result.add(getBaseLocations(ONE_CLOCK));
	    result.add(getBaseLocations(ELEVEN_CLOCK));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시: 11시, 5시, 1시 순서로 정찰
	    result.add(getBaseLocations(ELEVEN_CLOCK));
	    result.add(getBaseLocations(FIVE_CLOCK));
	    result.add(getBaseLocations(ONE_CLOCK));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시: 1시, 7시, 5시 순서로 정찰
	    result.add(getBaseLocations(ONE_CLOCK));
	    result.add(getBaseLocations(SEVEN_CLOCK));
	    result.add(getBaseLocations(FIVE_CLOCK));
	}

	return result;
    }

    // 배럭, 팩토리, 스타포트와 같은 병력 훈련용 타일의 위치를 지정한다. Add on 건물 위치까지 고려해야 한다.
    @Override
    public List<TilePosition> initTrainingBuildings() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시 ok
	    result.add(new TilePosition(108, 33));
	    result.add(new TilePosition(111, 19));
	    result.add(new TilePosition(111, 15));
	    result.add(new TilePosition(111, 11));
	    result.add(new TilePosition(111, 7));
	    result.add(new TilePosition(105, 7));
	    result.add(new TilePosition(105, 11));
	    result.add(new TilePosition(105, 15));
	    result.add(new TilePosition(118, 15));
	    result.add(new TilePosition(118, 19));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시 
	    result.add(new TilePosition(110, 92));
	    result.add(new TilePosition(110, 104));
	    result.add(new TilePosition(110, 108));
	    result.add(new TilePosition(117, 104));
	    result.add(new TilePosition(117, 108));
	    result.add(new TilePosition(110, 112));
	    result.add(new TilePosition(110, 116));
	    result.add(new TilePosition(110, 120));
	    result.add(new TilePosition(106, 108));
	    result.add(new TilePosition(106, 112));
	    result.add(new TilePosition(106, 116));
	    result.add(new TilePosition(106, 120));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시 ok
	    result.add(new TilePosition(16, 92));
	    result.add(new TilePosition(7, 106));
	    result.add(new TilePosition(13, 106));
	    result.add(new TilePosition(13, 109));
	    result.add(new TilePosition(7, 109));
	    result.add(new TilePosition(0, 109));
	    result.add(new TilePosition(0, 106));
	    result.add(new TilePosition(13, 113));
	    result.add(new TilePosition(13, 117));
	    result.add(new TilePosition(13, 121));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(14, 33));
	    result.add(new TilePosition(14, 16));
	    result.add(new TilePosition(14, 12));
	    result.add(new TilePosition(14, 8));
	    result.add(new TilePosition(8, 12));
	    result.add(new TilePosition(8, 16));
	    result.add(new TilePosition(8, 20));
	    result.add(new TilePosition(14, 20));
	    result.add(new TilePosition(0, 22));
	    result.add(new TilePosition(0, 18));
	}
	return result;
    }

    // 입구를 열고 닫을 배럭의 위치를 리턴한다.
    @Override
    public List<TilePosition> getBlockingEntranceBuilding() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    result.add(new TilePosition(108, 36));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    result.add(new TilePosition(107, 95));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    result.add(new TilePosition(17, 95));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    result.add(new TilePosition(15, 36));
	}

	return result;
    }

    // 본진 입구 벙커를 지을 위치를 설정한다.
    @Override
    public List<TilePosition> initBaseEntranceBunker() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(108, 31));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(110, 90));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(17, 90));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(17, 31));
	}
	return result;
    }

    // 3*2 사이즈 건물을 짓기 위한 위치들을 설정한다. (서플라이 디팟, 아마데미 등)
    public List<TilePosition> init3by2SizeBuildings() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    if (strategyManager.hasStrategyItem(StrategyItem.BLOCK_ENTRANCE_ZERG)) {
		//		result.add(new TilePosition(108, 31));
		result.add(new TilePosition(125, 20));
		result.add(new TilePosition(125, 18));
		result.add(new TilePosition(125, 16));
	    } else {
		result.add(new TilePosition(125, 25));
		result.add(new TilePosition(125, 23));
		result.add(new TilePosition(125, 21));
		result.add(new TilePosition(125, 19));
		result.add(new TilePosition(125, 17));
	    }

	    result.add(new TilePosition(125, 0));
	    result.add(new TilePosition(125, 2));
	    result.add(new TilePosition(125, 4));
	    result.add(new TilePosition(122, 0));
	    result.add(new TilePosition(122, 2));
	    result.add(new TilePosition(122, 4));
	    result.add(new TilePosition(119, 0));
	    result.add(new TilePosition(119, 2));
	    result.add(new TilePosition(116, 0));
	    result.add(new TilePosition(116, 2));
	    result.add(new TilePosition(113, 0));
	    result.add(new TilePosition(113, 2));
	    result.add(new TilePosition(110, 0));
	    result.add(new TilePosition(110, 2));
	    result.add(new TilePosition(107, 0));
	    result.add(new TilePosition(107, 2));
	    result.add(new TilePosition(107, 4));
	    result.add(new TilePosition(104, 0));
	    result.add(new TilePosition(104, 2));
	    result.add(new TilePosition(104, 4));
	    result.add(new TilePosition(101, 0));
	    result.add(new TilePosition(101, 2));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    if (strategyManager.hasStrategyItem(StrategyItem.BLOCK_ENTRANCE_ZERG)) {
		//		result.add(new TilePosition(110, 90));
		result.add(new TilePosition(125, 100));
	    } else {
		result.add(new TilePosition(125, 102));
		result.add(new TilePosition(125, 104));
		result.add(new TilePosition(125, 106));
	    }

	    result.add(new TilePosition(125, 102));
	    result.add(new TilePosition(125, 104));
	    result.add(new TilePosition(125, 106));
	    result.add(new TilePosition(125, 108));
	    result.add(new TilePosition(125, 110));
	    result.add(new TilePosition(125, 112));
	    result.add(new TilePosition(96, 125));
	    result.add(new TilePosition(99, 125));
	    result.add(new TilePosition(99, 123));
	    result.add(new TilePosition(102, 125));
	    result.add(new TilePosition(102, 123));
	    result.add(new TilePosition(105, 125));
	    result.add(new TilePosition(105, 123));
	    result.add(new TilePosition(108, 125));
	    result.add(new TilePosition(108, 123));
	    result.add(new TilePosition(111, 125));
	    result.add(new TilePosition(111, 123));
	    result.add(new TilePosition(114, 125));
	    result.add(new TilePosition(114, 123));
	    result.add(new TilePosition(117, 125));
	    result.add(new TilePosition(117, 123));
	    result.add(new TilePosition(120, 125));
	    result.add(new TilePosition(120, 123));
	    result.add(new TilePosition(117, 121));
	    result.add(new TilePosition(114, 125));

	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시

	    if (strategyManager.hasStrategyItem(StrategyItem.BLOCK_ENTRANCE_ZERG)) {
		//		result.add(new TilePosition(17, 90));
	    } else {
		result.add(new TilePosition(7, 102));
	    }

	    result.add(new TilePosition(8, 125));
	    result.add(new TilePosition(11, 125));
	    result.add(new TilePosition(14, 125));
	    result.add(new TilePosition(17, 125));
	    result.add(new TilePosition(20, 125));
	    result.add(new TilePosition(23, 125));
	    result.add(new TilePosition(26, 125));
	    result.add(new TilePosition(26, 123));
	    result.add(new TilePosition(23, 123));
	    result.add(new TilePosition(20, 123));
	    result.add(new TilePosition(23, 121));
	    result.add(new TilePosition(20, 121));
	    result.add(new TilePosition(20, 119));
	    result.add(new TilePosition(1, 115));
	    result.add(new TilePosition(4, 115));
	    result.add(new TilePosition(4, 113));
	    result.add(new TilePosition(1, 113));
	    result.add(new TilePosition(20, 117));
	    result.add(new TilePosition(20, 115));
	    result.add(new TilePosition(20, 113));
	    result.add(new TilePosition(20, 111));
	    result.add(new TilePosition(13, 103));
	    result.add(new TilePosition(8, 121));
	    result.add(new TilePosition(8, 123));
	    // 이거 두 개 위치 조금 애매함. 막힐 수 있음.
	    result.add(new TilePosition(29, 125));
	    result.add(new TilePosition(29, 123));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    //	    result.add(new TilePosition(17, 31));
	    result.add(new TilePosition(0, 0));
	    result.add(new TilePosition(0, 2));
	    result.add(new TilePosition(0, 4));
	    result.add(new TilePosition(3, 0));
	    result.add(new TilePosition(3, 2));
	    result.add(new TilePosition(3, 4));
	    result.add(new TilePosition(6, 0));
	    result.add(new TilePosition(6, 2));
	    result.add(new TilePosition(9, 0));
	    result.add(new TilePosition(9, 2));
	    result.add(new TilePosition(12, 0));
	    result.add(new TilePosition(12, 2));
	    result.add(new TilePosition(15, 0));
	    result.add(new TilePosition(15, 2));
	    result.add(new TilePosition(14, 4));
	    result.add(new TilePosition(18, 0));
	    result.add(new TilePosition(18, 2));
	    result.add(new TilePosition(17, 4));
	    result.add(new TilePosition(21, 0));
	    result.add(new TilePosition(21, 2));
	    result.add(new TilePosition(20, 4));
	    result.add(new TilePosition(24, 0));
	    result.add(new TilePosition(24, 2));
	    result.add(new TilePosition(23, 4));
	    result.add(new TilePosition(20, 6));
	    result.add(new TilePosition(20, 8));
	    result.add(new TilePosition(20, 10));
	    result.add(new TilePosition(20, 12));
	    result.add(new TilePosition(20, 14));
	}

	return result;
    }

    // 본진 가스를 짓기 위한 위치를 설정한다.
    @Override
    public List<TilePosition> initBaseRefinery() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(116, 4));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(117, 113));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(7, 113));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(7, 4));
	}

	return result;
    }

    // 본진 입구에 위치한 터렛의 위치를 설정한다.
    @Override
    public List<TilePosition> initBaseTurret() {
	// TODO 아직 미 구현됨.
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	}

	return result;
    }

    // 본진 입구 방어를 위한 위치를 설정한다.
    @Override
    public TilePosition initBaseEntranceChokePoint() {
	TilePosition result = null;

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result = new TilePosition(99, 33);
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result = new TilePosition(99, 92);
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result = new TilePosition(26, 94);

	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    result = new TilePosition(27, 34);
	}

	return result;
    }

    // 앞마당 입구 방어를 위한 위치를 설정한다.
    @Override
    public TilePosition initFirstExtensionChokePoint() {
	TilePosition result = null;

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result = new TilePosition(111, 32);
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result = new TilePosition(113, 91);
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result = new TilePosition(17, 97);
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result = new TilePosition(17, 32);
	}

	return result;
    }

    @Override
    public TilePosition getFirstExtensionChokePoint2() {
	TilePosition result = null;

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result = new TilePosition(113, 38);
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result = new TilePosition(110, 98);
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result = new TilePosition(17, 91);
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result = new TilePosition(15, 38);
	}

	return result;
    }

    @Override
    public List<TilePosition> initEngineeringBay() {
	return new ArrayList<TilePosition>();
    }

    @Override
    public List<TilePosition> initFirstExpansionTurret() {
	return new ArrayList<TilePosition>();
    }

    @Override
    public Set<TilePosition> getHillTilePosition() {
	Set<TilePosition> result = new HashSet<>();

	return result;
    }

    // 조이기 상태에서 적을 기다리고 있을 위치를 리턴한다.
    @Override
    public TilePosition getBlockingChokePoint() {
	TilePosition result = null;

	if (enemyStartLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    result = new TilePosition(66, 66);
	} else if (enemyStartLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    result = new TilePosition(66, 66);
	} else if (enemyStartLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    result = new TilePosition(66, 66);
	} else if (enemyStartLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    result = new TilePosition(66, 66);
	}

	return result;
    }

    @Override
    public List<TilePosition> getExtentionPosition() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    result.add(new TilePosition(117, 34));
	    result.add(new TilePosition(62, 5));
	    result.add(new TilePosition(110, 63));
	    result.add(new TilePosition(62, 119));
	    result.add(new TilePosition(14, 63));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    result.add(new TilePosition(117, 92));
	    result.add(new TilePosition(62, 119));
	    result.add(new TilePosition(110, 63));
	    result.add(new TilePosition(14, 63));
	    result.add(new TilePosition(62, 5));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    result.add(new TilePosition(7, 92));
	    result.add(new TilePosition(62, 119));
	    result.add(new TilePosition(14, 63));
	    result.add(new TilePosition(62, 5));
	    result.add(new TilePosition(110, 63));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    result.add(new TilePosition(7, 34));
	    result.add(new TilePosition(62, 5));
	    result.add(new TilePosition(62, 119));
	    result.add(new TilePosition(14, 63));
	    result.add(new TilePosition(110, 63));
	}

	return result;
    }

    // 확장시 배럭의 위치를 리턴한다.
    @Override
    public List<TilePosition> getSecondEntranceBuilding() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(104, 31));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(106, 90));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(20, 90));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(20, 31));
	}
	return result;
    }

    // 적 기지의 외곽을 따라 정찰하기 위한 위치를 리턴한다.
    @Override
    public List<TilePosition> getEnemyBaseSearchSequence() {
	if (enemyStartLocation != null) {
	    List<TilePosition> result = new ArrayList<>();
	    if (enemyStartLocation.equals(getBaseLocations(ONE_CLOCK))) {
		result.add(new TilePosition(104, 0));
		result.add(new TilePosition(125, 1));
		result.add(new TilePosition(125, 24));
		result.add(new TilePosition(105, 18));
	    } else if (enemyStartLocation.equals(getBaseLocations(FIVE_CLOCK))) {
		result.add(new TilePosition(125, 104));
		result.add(new TilePosition(125, 124));
		result.add(new TilePosition(102, 124));
		result.add(new TilePosition(108, 103));
	    } else if (enemyStartLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
		result.add(new TilePosition(20, 124));
		result.add(new TilePosition(0, 124));
		result.add(new TilePosition(0, 102));
		result.add(new TilePosition(19, 106));
	    } else if (enemyStartLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
		result.add(new TilePosition(1, 20));
		result.add(new TilePosition(1, 1));
		result.add(new TilePosition(20, 1));
		result.add(new TilePosition(20, 20));
	    }
	    return result;
	} else {
	    return null;
	}
    }

    @Override
    public List<TilePosition> getMineralExpansion() {

	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(89, 15));
	    result.add(new TilePosition(89, 110));
	    result.add(new TilePosition(35, 110));
	    result.add(new TilePosition(35, 15));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(89, 15));
	    result.add(new TilePosition(89, 110));
	    result.add(new TilePosition(35, 110));
	    result.add(new TilePosition(35, 15));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(89, 15));
	    result.add(new TilePosition(89, 110));
	    result.add(new TilePosition(35, 110));
	    result.add(new TilePosition(35, 15));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(89, 15));
	    result.add(new TilePosition(89, 110));
	    result.add(new TilePosition(35, 110));
	    result.add(new TilePosition(35, 15));
	}
	return result;
    }

}
