package Generic;

public abstract class GenericFather<T1, T2> {

}


//继承时两种情况，保留或不保留

//不保留时两种情况，没有类型（擦除）或具体类型
//没有类型
class Son1 extends GenericFather{};
//具体类型
class Son2 extends GenericFather<Integer, String>{};

//保留时两种情况，全部保留和部分保留
//部分保留
class Son3<T2> extends GenericFather<Integer, T2>{};
//全部保留
class Son4<T1, T2> extends GenericFather<T1, T2>{};