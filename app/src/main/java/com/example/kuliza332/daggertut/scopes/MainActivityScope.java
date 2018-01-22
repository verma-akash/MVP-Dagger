package com.example.kuliza332.daggertut.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by kuliza332 on 07/01/18.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface MainActivityScope {
}
