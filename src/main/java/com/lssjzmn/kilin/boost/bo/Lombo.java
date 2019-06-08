package com.lssjzmn.kilin.boost.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 使用 @Data 注解就可以有下面几个注解的功能：
 *
 * @ToString、@Getter、@Setter、@EqualsAndHashCode、@NoArgsConstructor
 * @Slf4j 在类上面注解了，直接调用 log 即可：
 * log.info(xxxx);
 * @Builder bulder 模式构建对象。
 */
@Data
public class Lombo implements Serializable {

    private Integer id;
    private String name;
    private String type;
}
