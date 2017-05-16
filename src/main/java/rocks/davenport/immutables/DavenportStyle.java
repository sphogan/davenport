package rocks.davenport.immutables;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@JsonSerialize
@Value.Style(
        get = {"is*", "get*"},
        init = "set*",
        typeAbstract = {"Abstract*", "*IF"},
        typeModifiable = "*",
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.SAME,
        jdkOnly = true,
        optionalAcceptNullable = true,
        isInitialized = "",
        create = "new",
        passAnnotations = {Entity.class, Id.class, GeneratedValue.class}
)
public @interface DavenportStyle {
}
