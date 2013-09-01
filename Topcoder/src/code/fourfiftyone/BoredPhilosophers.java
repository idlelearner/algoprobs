package code.fourfiftyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BoredPhilosophers {
	public static void main(String[] args) {
		BoredPhilosophers b = new BoredPhilosophers();
		// String text[] = { "aaa bbb aaa bbb aaa aaa" };
		String text[] = { "m nn r t n v oe at zd o v sd w jh u ki wq x lm bc ",
				"cb ms un hx rq sf jm k l c s ti rj dn td zs p oa v",
				" r q f pw ek m w cq u a x df r y hh bb de kg o im ",
				"a n i k pi fn s y eg s y wf c uo o e yf wa c rj fo",
				" ae cd x x y ey g u np yk u qb z hj wc r u ov e ai",
				" aq n d v sm xq nv r t i h wx a yx g ry cy km fb u",
				"d pa kp wm g e o x qy zr j tx or r vy r fi r d ao ",
				"l yw o b z hu os wm p mi c sz y lx ja p ss b z f g",
				"o w q rc rn z kn v fn u o h rd cf wq e hf qw ql qi",
				" xk kx yp w tp hk xc l e l we bj s fr qz s u nd f ",
				"bf xi y s or mn w v gg j ul lh nn q m i ju g jb ne",
				" ti q g zr gg lc w sf v a lf sw oc d ow z ee nd a ",
				"h qb pi jg ny e wt u vn jf su g f n eh gz v d lf f",
				" s he vg nc p l nx mq j jr b f bn p d w sl kv sl o",
				" n ee nd a h qb pi jg ny e us x p bo o ra zz ko jq",
				" ae wl wr lv umhu qm g b j v en sv x ap r u wl i t",
				" cl d w xd m mu ee r ed w au w i xk or h qw f ry k",
				"h dg ax im j kf m ct j gk fk hr yd g c ed i cc jh ",
				"q il a r j u qr w dw dv u z k v g rr fp eo o yn v ",
				"h s ti n t er o b jv pw x cz z a r w l w o v e qn ",
				"ga i iv kl zj q h c cd h iv jx z c kp k d d mk na ",
				"n ag c c b p bt qj uj zg b s l j t iv v ca rc ox e",
				"y cf sf xc e ul e pb f lk v u wf a c gd lo n s um ",
				"x r pk wj h wr bw o p iy kv an gs q we rl yo j gg ",
				"wn sf n ed q o x i o l t ck vr k e f h el g c u re",
				" yb ez ij l x y s x c v rlo tj qc u d jr t ej i d ",
				"ch ee r ed w au w i xk or h qw f ry kh dg ax im j ",
				"kf k fa jr i r w y k jk h e xi ot j t l q pv ti v ",
				"y op ip f i j xb r zf t eg rd w nz i ia qw t ah yf",
				" zd aa xb i a k o hl qa vd tp kk p xf t gt sw c i ",
				"r u i qf h xs az is u an w qy kl q a mb vo wf b ew",
				" l o l c pj md l ar ax m lx h j a ie nk l b r y i ",
				"l yd bs ti id wn t l qb mq w s op x re mw q q r jy",
				" l up ml i ao as v o y xc e ul e pb f lk v u wf a ",
				"c gd lo n s um x r pk wj h wr bw o p iy j v en sv ",
				"x ap r u wl i t cl d w xd m mu rp u l kh ljf i t x",
				"s f su kg w s vx x ru u ob x v mb o tr ap d tu jt ",
				"oh qp lv d e xb jf ar q w x hw o wl w xb zp l nx m",
				"q j jr b f bn p d w sl kv sl o n ee nd a h qb wd u",
				" s eb hu y sy ij jq b fb ya ci w f pe lq sa po ua ",
				"o y u i ez wd d z i d kn ns q s vx l np ra r j eb ",
				"e u l j v tt h x nz c v c f t m hu zy wt jx th wu ",
				"cq y cw c e cd z zu qs i u s t j fp sk b a n ex zh",
				" ae uu y zv mq pp wg y v w s op x re mw q q r jy l",
				" up ml m k w re tw pz a gd nd d qq q g oj yg id je",
				" kd q za nz z sl r db sn k fa o a h or co a kr f s",
				" r qm og eo f jr kt ls gw i b ze b ez ij l x y s x",
				" c v rg e g o o e k f d oh aq bw n d zq h f w a u ",
				"u xa hu qm g b j v en sv x ap r u wl i t cl d w xd",
				" m mu rp u l kh lj" };

		System.out.println(Arrays.toString(b.simulate(text, 16)));
	}

	public int[] simulate(String text[], int N) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Integer> in = new ArrayList<Integer>();
		StringBuilder str = new StringBuilder();
		for (String s : text)
			str.append(s);
		text = str.toString().split(" ");
		for (int i = 0; i < text.length; i++) {
			Integer b4 = map.get(text[i]);
			if (b4 == null) {
				b4 = map.size();
				map.put(text[i], b4);
			}
			in.add(b4);
		}

		int out[] = new int[N];
		for (int i = 1; i <= N; i++) {
			Set<Integer> lengths = new HashSet<Integer>();
			ArrayList<Integer> carrier = new ArrayList<Integer>();
			int j;
			for (j = 0; j < i; j++)
				carrier.add(in.get(j));
			lengths.add(carrier.hashCode());
			while (j < in.size()) {
				carrier.remove(0);
				carrier.add(in.get(j));
				lengths.add(carrier.hashCode());
				j++;
			}
			out[i - 1] = lengths.size();
		}
		return out;
	}
}
