package rocks.davenport.daos;

import com.google.common.base.Function;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Relationer {
    public static <A, B> List<A> relationer(List<A> listWithRelation,
                                            Function<A, Integer> idFunction,
                                            BiFunction<A, Iterable<? extends B>, A> withRelatedFunc,
                                            List<B> relatedItems,
                                            Function<B, Integer> foreignKey) {
        Multimap<Integer, B> idToRelatedItems = Multimaps.index(relatedItems, foreignKey);

        return listWithRelation.stream()
                .map(i -> withRelatedFunc.apply(i, idToRelatedItems.get(idFunction.apply(i))))
                .collect(Collectors.toList());
    }
}
