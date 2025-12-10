package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@NoArgsConstructor
public class Notification {

	private String errorMessage;
	private String notificationType;


}
