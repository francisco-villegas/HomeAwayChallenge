package com.example.pancho.homeawaychallenge.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Francisco on 10/18/2017.
 */

@Documented
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface CustomScope {
}
