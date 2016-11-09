package x3.benjamin.study.async;

import java.util.Optional;

public class OptionalExample2 {
	public static void main(String[] args) {
		Optional<String> opt = Optional.empty();
		System.out.println(opt.map(s -> "Not null : " + s).orElse("Not Null"));
	}
}
