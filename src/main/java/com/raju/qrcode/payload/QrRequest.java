package com.raju.qrcode.payload;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QrRequest {
    String content;
}
