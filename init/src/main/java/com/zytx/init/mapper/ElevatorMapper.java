package com.zytx.init.mapper;

import com.zytx.init.domain.ElevatorCoordinate;
import com.zytx.init.domain.ElevatorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ElevatorMapper {

    List<ElevatorInfo> findCantConfirmByCoordinate(@Param("start") int start,@Param("end") int end);

    List<ElevatorInfo> updateCoordinate(@Param("start") int start,@Param("end") int end);

    long updateCoordinateCount();

    void updateCoordinateInsert(@Param("map_X") String map_X,@Param("map_Y") String map_Y,@Param("precise") String precise,@Param("id") int id);

    long confirmCoordinateByAllCount(@Param("sign") int sign);

    List<ElevatorCoordinate> confirmCoordinateByAll(@Param("start") int start,@Param("end") int end,@Param("sign") int sign);

    void updateConfirmCoordinate(@Param("map_X") String map_X,@Param("map_Y") String map_Y,@Param("dealCoordinate") int dealCoordinate,@Param("id") int id);


    long confirmCoordinateBybdCount();

    List<ElevatorInfo> confirmCoordinateBybd(@Param("start") int start,@Param("end") int end);

    void updateConfirmCoordinateBybd(@Param("dealCoordinate") int dealCoordinate,@Param("id") int id);

    void personConfirmCoordinate(@Param("map_X") String map_X,@Param("map_Y") String map_Y,@Param("dealCoordinate") int dealCoordinate,@Param("registNumber") String registNumber,@Param("sign") int sign);

    void setPreciseIsNull();

    long cheeckCoordinateCount(@Param("sign") int sign);

    List<ElevatorInfo> cheeckCoordinate(@Param("start") int start,@Param("end") int end,@Param("sign") int sign);

    void cheeckCoordinateUpdate(@Param("id") int id,@Param("sign") int sign);

    long updateCoordinateNoRewriteCount();

    List<ElevatorInfo> updateCoordinateNoRewrite(@Param("start") int start,@Param("end") int end);
}
