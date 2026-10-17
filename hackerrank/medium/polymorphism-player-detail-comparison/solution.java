import java.util.*;

class Player {
    private String name;
    private String country;
    private String skill;

    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getSkill() { return skill; }

    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }
    public void setSkill(String skill) { this.skill = skill; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player o = (Player) obj;
        return Objects.equals(name, o.name)
            && Objects.equals(country, o.country)
            && Objects.equals(skill, o.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, skill);
    }
}

public class Main {
    static Player readPlayer(Scanner sc, int no) {
        Player p = new Player();
        System.out.println("Enter the player " + no + " details");
        System.out.println("Enter the player name");
        p.setName(sc.hasNextLine() ? sc.nextLine() : "");
        System.out.println("Enter the country name ");
        p.setCountry(sc.hasNextLine() ? sc.nextLine() : "");
        System.out.println("Enter the skill");
        p.setSkill(sc.hasNextLine() ? sc.nextLine() : "");
        return p;
    }

    static void show(Player p) {
        System.out.println(p.getName() + "----- " + p.getCountry() + "------ " + p.getSkill());
    }

    // value after "Label:" on lines starting with that label
    static List<String> values(List<String> lines, String label) {
        List<String> res = new ArrayList<>();
        for (String l : lines) {
            String t = l.trim();
            if (t.startsWith(label)) res.add(t.substring(label.length()).trim());
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) all.add(in.nextLine());
        in.close();

        Scanner sc = new Scanner(String.join("\n", all));

        Player p1 = readPlayer(sc, 1);
        show(p1);
        System.out.println();
        Player p2 = readPlayer(sc, 2);
        show(p2);

        // compare the actual values if the input has labels, else the raw ones
        List<String> n = values(all, "Name:");
        List<String> c = values(all, "Country:");
        List<String> s = values(all, "Skill:");
        Player a = p1, b = p2;
        if (n.size() >= 2 && c.size() >= 2 && s.size() >= 2) {
            a = new Player(); b = new Player();
            a.setName(n.get(0)); a.setCountry(c.get(0)); a.setSkill(s.get(0));
            b.setName(n.get(1)); b.setCountry(c.get(1)); b.setSkill(s.get(1));
        }

        if (a.equals(b)) {
            System.out.println("Both the player details are same.");
        } else {
            System.out.println("Both the player details are different.");
        }
        sc.close();
    }
}
