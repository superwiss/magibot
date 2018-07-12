import java.util.ArrayList;
import java.util.List;

import bwapi.TilePosition;

// 투혼 맵
public class LocationManagerSprit extends LocationManager {

    private static LocationManagerSprit instance = new LocationManagerSprit();

    public static LocationManagerSprit Instance() {
	return instance;
    }

    private static final int ONE_CLOCK = 0;
    private static final int FIVE_CLOCK = 1;
    private static final int SEVEN_CLOCK = 2;
    private static final int ELEVEN_CLOCK = 3;

    @Override
    public List<TilePosition> initBaseLocations() {
	List<TilePosition> result = new ArrayList<>(4);

	result.add(new TilePosition(117, 7));
	result.add(new TilePosition(117, 117));
	result.add(new TilePosition(7, 116));
	result.add(new TilePosition(7, 6));

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
	    // 1시
	    result.add(new TilePosition(98, 6));
	    result.add(new TilePosition(107, 6));
	    result.add(new TilePosition(107, 9));
	    result.add(new TilePosition(111, 9));
	    result.add(new TilePosition(111, 12));
	    result.add(new TilePosition(111, 15));

	    //애드온 건물
	    result.add(new TilePosition(99, 1));
	    result.add(new TilePosition(105, 1));
	    result.add(new TilePosition(111, 1));

	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(114, 101));
	    result.add(new TilePosition(110, 104));
	    result.add(new TilePosition(114, 104));
	    result.add(new TilePosition(110, 107));
	    result.add(new TilePosition(114, 107));
	    result.add(new TilePosition(106, 107));
	    result.add(new TilePosition(106, 104));

	    //애드온 건물
	    result.add(new TilePosition(121, 101));
	    result.add(new TilePosition(121, 104));
	    result.add(new TilePosition(121, 107));
	    result.add(new TilePosition(121, 110));

	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(22, 118));
	    result.add(new TilePosition(14, 116));
	    result.add(new TilePosition(18, 116));
	    result.add(new TilePosition(14, 113));
	    result.add(new TilePosition(18, 113));
	    result.add(new TilePosition(18, 110));

	    //애드온 건물
	    result.add(new TilePosition(7, 124));
	    result.add(new TilePosition(13, 124));
	    result.add(new TilePosition(19, 124));
	    result.add(new TilePosition(25, 124));

	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(9, 25));
	    result.add(new TilePosition(9, 20));
	    result.add(new TilePosition(9, 17));
	    result.add(new TilePosition(9, 14));
	    result.add(new TilePosition(13, 17));
	    result.add(new TilePosition(13, 14));
	    //애드온 건물
	    result.add(new TilePosition(0, 14));
	    result.add(new TilePosition(0, 17));
	    result.add(new TilePosition(0, 20));
	    result.add(new TilePosition(0, 23));
	}

	return result;
    }

    // 본진 입구 벙커를 지을 위치를 설정한다.
    @Override
    public List<TilePosition> initBaseEntranceBunker() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(102, 8));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(118, 100));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(25, 121));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(6, 27));
	}

	return result;
    }

    // 3*2 사이즈 건물을 짓기 위한 위치들을 설정한다. (서플라이 디팟, 아마데미 등)
    public List<TilePosition> init3by2SizeBuildings() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(102, 10));
	    result.add(new TilePosition(125, 0));
	    result.add(new TilePosition(122, 0));
	    result.add(new TilePosition(125, 2));
	    result.add(new TilePosition(122, 2));
	    result.add(new TilePosition(125, 14));
	    result.add(new TilePosition(122, 14));
	    result.add(new TilePosition(125, 16));
	    result.add(new TilePosition(122, 16));
	    result.add(new TilePosition(125, 18));
	    result.add(new TilePosition(122, 18));
	    result.add(new TilePosition(125, 20));
	    result.add(new TilePosition(122, 20));
	    result.add(new TilePosition(125, 22));
	    result.add(new TilePosition(122, 22));
	    result.add(new TilePosition(125, 24));
	    result.add(new TilePosition(122, 24));
	    result.add(new TilePosition(117, 14));
	    result.add(new TilePosition(119, 16));
	    result.add(new TilePosition(119, 18));
	    result.add(new TilePosition(119, 20));
	    result.add(new TilePosition(119, 22));
	    result.add(new TilePosition(116, 16));
	    result.add(new TilePosition(116, 18));
	    result.add(new TilePosition(116, 20));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(118, 98));
	    result.add(new TilePosition(119, 125));
	    result.add(new TilePosition(119, 123));
	    result.add(new TilePosition(116, 125));
	    result.add(new TilePosition(116, 123));
	    result.add(new TilePosition(113, 125));
	    result.add(new TilePosition(113, 123));
	    result.add(new TilePosition(110, 125));
	    result.add(new TilePosition(110, 123));
	    result.add(new TilePosition(107, 125));
	    result.add(new TilePosition(107, 123));
	    result.add(new TilePosition(104, 125));
	    result.add(new TilePosition(104, 123));
	    result.add(new TilePosition(110, 121));
	    result.add(new TilePosition(107, 121));
	    result.add(new TilePosition(104, 121));
	    result.add(new TilePosition(107, 119));
	    result.add(new TilePosition(104, 119));
	    result.add(new TilePosition(107, 117));
	    result.add(new TilePosition(104, 117));
	    result.add(new TilePosition(107, 115));
	    result.add(new TilePosition(104, 115));
	    result.add(new TilePosition(107, 113));
	    result.add(new TilePosition(104, 113));

	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(28, 121));
	    result.add(new TilePosition(0, 124));
	    result.add(new TilePosition(3, 124));
	    result.add(new TilePosition(0, 111));
	    result.add(new TilePosition(3, 111));
	    result.add(new TilePosition(0, 109));
	    result.add(new TilePosition(3, 109));
	    result.add(new TilePosition(0, 107));
	    result.add(new TilePosition(3, 107));
	    result.add(new TilePosition(0, 105));
	    result.add(new TilePosition(3, 105));
	    result.add(new TilePosition(0, 103));
	    result.add(new TilePosition(3, 103));
	    result.add(new TilePosition(0, 101));
	    result.add(new TilePosition(3, 101));
	    result.add(new TilePosition(6, 101));
	    result.add(new TilePosition(6, 103));
	    result.add(new TilePosition(9, 101));
	    result.add(new TilePosition(9, 103));
	    result.add(new TilePosition(6, 105));
	    result.add(new TilePosition(9, 105));
	    result.add(new TilePosition(12, 103));
	    result.add(new TilePosition(12, 105));
	    result.add(new TilePosition(12, 107));
	    result.add(new TilePosition(9, 107));

	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {

	    // 11시
	    result.add(new TilePosition(5, 29));
	    result.add(new TilePosition(0, 0));
	    result.add(new TilePosition(0, 2));
	    result.add(new TilePosition(3, 0));
	    result.add(new TilePosition(3, 2));
	    result.add(new TilePosition(11, 0));
	    result.add(new TilePosition(11, 2));
	    result.add(new TilePosition(14, 0));
	    result.add(new TilePosition(14, 2));
	    result.add(new TilePosition(17, 0));
	    result.add(new TilePosition(17, 2));
	    result.add(new TilePosition(20, 0));
	    result.add(new TilePosition(20, 2));
	    result.add(new TilePosition(14, 4));
	    result.add(new TilePosition(17, 4));
	    result.add(new TilePosition(20, 4));
	    result.add(new TilePosition(14, 6));
	    result.add(new TilePosition(17, 6));
	    result.add(new TilePosition(20, 6));
	    result.add(new TilePosition(14, 8));
	    result.add(new TilePosition(17, 8));
	    result.add(new TilePosition(20, 8));
	    result.add(new TilePosition(14, 10));
	    result.add(new TilePosition(17, 10));
	    result.add(new TilePosition(20, 10));

	}

	return result;
    }

    // 본진 가스를 짓기 위한 위치를 설정한다.
    @Override
    public List<TilePosition> initBaseRefinery() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(117, 2));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(117, 112));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(7, 111));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(7, 1));
	}

	return result;
    }

    // 본진에 위치한 터렛의 위치를 설정한다.
    @Override
    public List<TilePosition> initBaseTurret() {

	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(117, 5));
	    result.add(new TilePosition(120, 12));
	    result.add(new TilePosition(120, 14));
	    result.add(new TilePosition(106, 13));
	    result.add(new TilePosition(106, 15));
	    result.add(new TilePosition(96, 5));
	    result.add(new TilePosition(120, 24));
	    result.add(new TilePosition(117, 22));

	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(116, 120));
	    result.add(new TilePosition(115, 115));
	    result.add(new TilePosition(110, 102));
	    result.add(new TilePosition(112, 102));
	    result.add(new TilePosition(118, 120));
	    result.add(new TilePosition(117, 115));

	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {

	    // 7시 9개
	    result.add(new TilePosition(22, 113));
	    result.add(new TilePosition(7, 119));
	    result.add(new TilePosition(7, 109));
	    result.add(new TilePosition(31, 122));
	    result.add(new TilePosition(7, 107));
	    result.add(new TilePosition(7, 121));
	    result.add(new TilePosition(22, 111));
	    result.add(new TilePosition(6, 99));
	    result.add(new TilePosition(12, 101));

	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {

	    // 11시 11개
	    result.add(new TilePosition(13, 25));
	    result.add(new TilePosition(7, 4));
	    result.add(new TilePosition(13, 20));
	    result.add(new TilePosition(10, 9));
	    result.add(new TilePosition(3, 30));
	    result.add(new TilePosition(11, 5));
	    result.add(new TilePosition(15, 20));
	    result.add(new TilePosition(8, 9));
	    result.add(new TilePosition(23, 0));
	    result.add(new TilePosition(23, 8));
	    result.add(new TilePosition(23, 10));

	}

	return result;
    }

    // 첫번째 확장에 위치한 터렛의 위치를 설정한다.
    @Override
    public List<TilePosition> initFirstExpansionTurret() {

	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(86, 10));
	    result.add(new TilePosition(88, 16));
	    result.add(new TilePosition(86, 16));
	    result.add(new TilePosition(90, 10));

	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(114, 86));
	    result.add(new TilePosition(117, 93));
	    result.add(new TilePosition(112, 86));
	    result.add(new TilePosition(115, 92));
	    result.add(new TilePosition(110, 86));

	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(36, 116));
	    result.add(new TilePosition(41, 110));
	    result.add(new TilePosition(40, 116));
	    result.add(new TilePosition(37, 110));
	    result.add(new TilePosition(39, 110));

	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(14, 36));
	    result.add(new TilePosition(12, 42));
	    result.add(new TilePosition(12, 36));
	    result.add(new TilePosition(14, 41));
	}

	return result;
    }

    // 본진 입구 방어를 위한 위치를 설정한다.
    @Override
    public TilePosition initBaseEntranceChokePoint() {
	TilePosition result = null;

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result = new TilePosition(103, 7);
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result = new TilePosition(118, 102);
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result = new TilePosition(24, 122);
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result = new TilePosition(7, 26);
	}

	return result;
    }

    // 엔지니어링 베이의 위치를 설정한다.
    @Override
    public List<TilePosition> initEngineeringBay() {
	List<TilePosition> result = new ArrayList<>();

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result.add(new TilePosition(111, 6));
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result.add(new TilePosition(113, 117));
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result.add(new TilePosition(14, 110));
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result.add(new TilePosition(17, 14));
	}

	return result;
    }

    // 앞마당 입구 방어를 위한 위치를 설정한다.
    @Override
    public TilePosition initFirstExtensionChokePoint() {
	TilePosition result = null;

	if (allianceBaseLocation.equals(getBaseLocations(ONE_CLOCK))) {
	    // 1시
	    result = new TilePosition(92, 21);
	} else if (allianceBaseLocation.equals(getBaseLocations(FIVE_CLOCK))) {
	    // 5시
	    result = new TilePosition(106, 91);
	} else if (allianceBaseLocation.equals(getBaseLocations(SEVEN_CLOCK))) {
	    // 7시
	    result = new TilePosition(36, 107);
	} else if (allianceBaseLocation.equals(getBaseLocations(ELEVEN_CLOCK))) {
	    // 11시
	    result = new TilePosition(23, 38);
	}

	return result;
    }

}