/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.architecture;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark a class as a domain model.
 * Domain models are used to represent the data and business logic of a
 * specific domain within an application.
 * By annotating a class with {@link DomainModel}, it signifies that the
 * class is a domain model in the application.
 *
 * <p>
 * Usage example:
 * <pre>{@code
 *   @DomainModel
 *   public class User {
 *       // Members and methods representing user data and behavior
 *   }
 * }</pre>
 * </p>
 *
 * <p>
 * Note that this annotation does not provide any additional functionality on its own.
 * It is purely used for marking a class as a domain model.
 * </p>
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface DomainModel {
}
