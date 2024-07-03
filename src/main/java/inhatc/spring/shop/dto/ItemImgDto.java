package inhatc.spring.shop.dto;

import inhatc.spring.shop.entity.ItemImg;
import lombok.*;
import org.modelmapper.ModelMapper;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImgDto {
    private Long id; // 아이디

    private String imgName; // 이미지 파일명

    private String oriImgName; // 원본 이미지 파일명

    private String imgUrl; // 이미지 파일 경로

    private String repImgYn; // 대표 이미지 여부

    private static ModelMapper modelMapper = new ModelMapper();

    // entity -> dto
    public static ItemImgDto entityToDto(ItemImg itemImg) {
        // MapperConfig 클래스를 생성 안 할 경우
       // ItemImgDto itemImgDto = modelMapper.map(itemImg, ItemImgDto.class);
        return modelMapper.map(itemImg, ItemImgDto.class);
    }
}
