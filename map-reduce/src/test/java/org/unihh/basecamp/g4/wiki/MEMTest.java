package org.unihh.basecamp.g4.wiki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(MockitoJUnitRunner.class)
public class MEMTest {

    @Test
    public void test(){
        // regex test
        String abc = "| name = Ealdred | title = [[Archbishop of York]] | image = Gloucester catedral anglosajon.JPG | imagesize = 250px | alt\n" +
                "= Interior view of a chamber, with arches supporting the pillars holding up the roof. | caption = Crypt of Gloucester\n" +
                "Cathedral, which predates the [[Norman conquest of England|Norman Conquest]], and would have been contemporary with\n" +
                "Ealdred's administration of [[Gloucester Abbey]] | elected = 25 December 1060 | ended = 11 September 1069 | other_post =\n" +
                "[[Abbot of Tavistock]]&lt;br&gt;[[Bishop of Worcester]] | predecessor = [[Cynesige]] | successor = [[Thomas of Bayeux]]\n" +
                "| consecration = 1046 | death_date = 11 September 1069 | death_place = [[York]] | buried = [[York Minster]] }}\n" +
                "'''Ealdred''' (or '''Aldred''';&lt;ref name=DNB/&gt; died 11 September 1069) was [[Abbot of Tavistock]], [[Bishop of\n" +
                "Worcester]], and [[Archbishop of York]] in [[History of Anglo-Saxon England|Anglo-Saxon England]]. He was related to a\n" +
                "number of other ecclesiastics of the period. After becoming a monk at the monastery at [[Winchester]], he was appointed\n" +
                "[[Abbot]] of [[Tavistock Abbey]] in around 1027. In 1046 he was named to the Bishopric of Worcester. Ealdred, besides\n" +
                "his episcopal duties, served [[Edward the Confessor]], the King of England, as a diplomat and as a military leader. He\n" +
                "worked to bring one of the king's relatives, [[Edward the Exile]], back to England from Hungary to secure an heir for\n" +
                "the childless king. In 1058 he undertook a pilgrimage to Jerusalem, the first bishop from England to do so.&lt;ref\n" +
                "name=Edward208&gt;Barlow ''Edward the Confessor'' pp. 208&#8211;209&lt;/ref&gt; As administrator of the [[Diocese of\n" +
                "Hereford]], he was involved in fighting against the Welsh, suffering two defeats at the hands of raiders before securing\n" +
                "a settlement with [[Gruffydd ap Llywelyn]], a Welsh ruler. In 1060, Ealdred was elected to the archbishopric of York,\n" +
                "but had difficulty in obtaining papal approval for his appointment, only managing to do so when he promised not to hold\n" +
                "the bishoprics of York and Worcester simultaneously. He helped secure the election of [[Wulfstan (Bishop of\n" +
                "Worcester)|Wulfstan]] as his successor at Worcester. During his archiepiscopate, he built and embellished churches in\n" +
                "his diocese, and worked to improve his clergy by holding a synod which published regulations for the priesthood. Some\n" +
                "sources state that following King Edward the Confessor's death in 1066, it was Ealdred who crowned [[Harold Godwinson]]\n" +
                "as King of England.&lt;ref name=Hindley335&gt;Hindley ''Brief History of the Anglo-Saxons'' p. 335&lt;/ref&gt; Ealdred\n" +
                "supported Harold as king, but when Harold was defeated at the [[Battle of Hastings]], Ealdred backed [[Edgar the &#198;theling]]\n" +
                "and then endorsed King [[William I of England|William the Conqueror]], the [[Duke of Normandy]] and a distant relative\n" +
                "of King Edward's. Ealdred crowned King William on Christmas Day in 1066. William never quite trusted Ealdred or the\n" +
                "other English leaders, and Ealdred had to accompany William back to Normandy in 1067, but he had returned to York by the\n" +
                "time of his death in 1069. Ealdred supported the churches and monasteries in his diocese with gifts and building\n" +
                "projects. ==Early life== Ealdred was probably born in the west of England, and could be related to [[Lyfing of\n" +
                "Winchester|Lyfing]], his predecessor as bishop of Worcester.&lt;ref name=DNB&gt;Lawson \"Ealdred\" ''Oxford Dictionary of\n" +
                "National Biography''&lt;/ref&gt; His family, from Devonshire, may have been well-to-do.&lt;ref name=King124&gt;King\n" +
                "\"Ealdred\" ''Anglo-Norman Studies XVIII'' p. 124&lt;/ref&gt; Another relative was Wilstan or Wulfstan, who under\n" +
                "Ealdred's influence became [[Abbot of Gloucester]].&lt;ref name=DNB/&gt; Ealdred was a monk in the [[cathedral chapter]]\n" +
                "at [[Winchester Cathedral]] before becoming abbot of Tavistock Abbey about 1027, an office he held until about 1043.&lt;ref\n" +
                "name=Knowles72&gt;Knowles ''Monastic Order in England'' p. 72&lt;/ref&gt; Even after leaving the abbacy of Tavistock, he\n" +
                "continued to hold two properties from the abbey until his death.&lt;ref name=King124/&gt; No contemporary documents\n" +
                "relating to Ealdred's time as abbot have been discovered.&lt;ref name=King125&gt;King \"Ealdred\" ''Anglo-Norman Studies\n" +
                "XVIII'' p. 125&lt;/ref&gt; Ealdred was made bishop of Worcester in 1046, a position he held until his resignation in\n" +
                "1062.&lt;ref name=Handbook224&gt;Fryde, et al. ''Handbook of British Chronology'' p. 224&lt;/ref&gt; He may have acted\n" +
                "as [[Suffragan bishop|suffragan]], or subordinate bishop, to his predecessor Lyfing before formally assuming the\n" +
                "bishopric,&lt;ref name=DNB/&gt;&lt;ref name=Edward86&gt;Barlow ''Edward the Confessor'' p. 86&lt;/ref&gt; as from about\n" +
                "1043 Ealdred witnessed as an ''episcopus'', or bishop, and a charter from 1045 or early 1046 names Sihtric as abbot of\n" +
                "Tavistock.&lt;ref name=King125/&gt; Lyfing died on 26 March 1046, and Ealdred became bishop of Worcester shortly after.\n" +
                "However, Ealdred did not receive the other two dioceses that Lyfing had held, [[Bishop of Crediton|Crediton]] and\n" +
                "[[Bishop of Cornwall|Cornwall]]; King Edward the Confessor (reigned 1043&#8211;1066) granted these to [[Leofric\n" +
                "(bishop)|Leofric]], who combined the two sees at Crediton in 1050.&lt;ref name=King125/&gt; ==Bishop and royal advisor==\n" +
                "[[Image:Harold2.jpg|thumb|upright=1.8|right|Harold Godwinson, from the [[Bayeux Tapestry]], whom Ealdred failed to catch\n" +
                "in 1051|alt=Tapestry image of a man on horseback holding a falcon]] Ealdred was an advisor to King Edward the Confessor,\n" +
                "and was often involved in the royal government.&lt;ref name=Huscroft49/&gt; He was also a military leader, and in 1046\n" +
                "he led an unsuccessful expedition against the Welsh.&lt;ref name=Huscroft49&gt;Huscroft ''Ruling England'' p. 49&lt;/ref&gt;\n" +
                "This was in retaliation for a raid led by the Welsh rulers [[Gruffydd ap Rhydderch]], [[Rhys ap Rhydderch]], and\n" +
                "Gruffydd ap Llywelyn. Ealdred's expedition was betrayed by some Welsh soldiers who were serving with the English, and\n" +
                "Ealdred was defeated.&lt;ref name=Maund89&gt;Maund ''Welsh Kings'' pp. 89&#8211;90&lt;/ref&gt; In 1050, Ealdred went to\n" +
                "Rome \"on the king's errand\",&lt;ref name=Huscroft50&gt;Huscroft ''Ruling England'' p. 50&lt;/ref&gt; apparently to\n" +
                "secure papal approval to move the seat, or centre, of the bishopric of Crediton to Exeter. It may also have been to\n" +
                "secure the release of the king from a vow to go on pilgrimage, if sources from after the [[Norman Conquest of England]]\n" +
                "are to be believed.&lt;ref name=DNB/&gt; While in Rome, he attended a papal council, along with his fellow English\n" +
                "bishop [[Herman (bishop)|Herman]].&lt;ref name=Smith574&gt;Smith, et al. \"Court and Piety\" ''Catholic Historical\n" +
                "Review'' p. 574&lt;/ref&gt; That same year, as Ealdred was returning to England he met [[Sweyn Godwinson|Sweyn]], a son\n" +
                "of [[Godwin, Earl of Wessex]], and probably absolved Sweyn for having abducted the abbess of [[Leominster Abbey]] in\n" +
                "1046.&lt;ref name=Godwins55&gt;Barlow ''Godwins'' p. 55&lt;/ref&gt; Through Ealdred's intercession, Sweyn was restored\n" +
                "to his earldom, which he had lost after abducting the abbess and murdering his cousin [[Beorn Estrithson]].&lt;ref\n" +
                "name=Rex37&gt;Rex ''Harold II'' p. 37&lt;/ref&gt;&lt;ref name=Edward103&gt;Barlow ''Edward the Confessor'' p. 103&lt;/ref&gt;\n" +
                "Ealdred helped Sweyn not only because Ealdred was a supporter of [[House of Godwin|Earl Godwin's family]] but because\n" +
                "Sweyn's earldom was close to his bishopric. As recently as 1049 Irish raiders had allied with Gruffydd ap Rhydderch of\n" +
                "[[Kingdom of Gwent|Gwent]] in raiding along the [[River Usk]]. Ealdred unsuccessfully tried to drive off the raiders,\n" +
                "but was again routed by the Welsh. This failure underscored Ealdred's need for a strong earl in the area to protect\n" +
                "against raids.&lt;ref name=Mason57&gt;Mason ''House of Godwine'' pp. 57&#8211;58&lt;/ref&gt; Normally, the [[bishop of\n" +
                "Hereford]] would have led the defence in the absence of an Earl of Hereford, but in 1049 the incumbent, [[&#198;thelstan\n" +
                "(Bishop of Hereford)|&#198;thelstan]], was blind, so Ealdred took on the role of defender.&lt;ref name=King126&gt;King\n" +
                "\"Ealdred\" ''Anglo-Norman Studies XVIII'' pp. 126&#8211;127&lt;/ref&gt; ==Diplomatic travels== Earl Godwin's rebellion\n" +
                "against the king in 1051 came as a blow to Ealdred, who was a supporter of the earl and his family. Ealdred was present\n" +
                "at the royal council at London that banished Godwin's family.&lt;ref name=King127&gt;King \"Ealdred\" ''Anglo-Norman\n" +
                "Studies XVIII'' p. 127&lt;/ref&gt; Later in 1051, when he was sent to intercept Harold Godwinson and his brothers as\n" +
                "they fled England after their father's outlawing, Ealdred \"could not, or would not\" capture the brothers.&lt;ref\n" +
                "name=Harold132&gt;Walker ''Harold'' pp. 132&#8211;133&lt;/ref&gt;&lt;ref name=Edward114&gt;Barlow ''Edward the\n" +
                "Confessor'' p. 114&lt;/ref&gt; The banishment of Ealdred's patron came shortly after the death of [[&#198;lfric\n" +
                "Puttoc]], the Archbishop of York. York and Worcester had long had close ties, and the two sees had often been held in\n" +
                "[[Benefice|plurality]], or at the same time. Ealdred probably wanted to become Archbishop of York after &#198;lfric's\n" +
                "death, but his patron's eclipse led to the king appointing [[Cynesige]], a royal chaplain, instead.&lt;ref name=King127/&gt;\n" +
                "In September 1052, though, Godwin returned from exile and his family was restored to power.&lt;ref name=Huscroft6&gt;Huscroft\n" +
                "''Ruling England'' pp. 6&#8211;7&lt;/ref&gt; By late 1053 Ealdred was once more in royal favour.&lt;ref name=King127/&gt;\n" +
                "At some point, he was alleged to have accompanied Swein on a pilgrimage to the Holy Land, but proof is lacking.&lt;ref\n" +
                "name=Fleming79&gt;Fleming ''Kings &amp; Lords in Conquest England'' pp. 79&#8211;80&lt;/ref&gt;{{efn|If he did accompany\n" +
                "Swein, the historian [[Frank Barlow (historian)|Frank Barlow]] argues that it was probably in 1058.&lt;ref\n" +
                "name=BarlowChurch88&gt;Barlow ''English Church 1000&#8211;1066'' p. 88&lt;/ref&gt;}} In 1054 King Edward sent Ealdred to\n" +
                "Germany to obtain Emperor [[Henry III, Holy Roman Emperor|Henry III]]'s help in returning [[Edward the Exile]], son of\n" +
                "[[Edmund Ironside]], to England. Edmund (reigned 1016) was an elder half-brother of King Edward the Confessor, and\n" +
                "Edmund's son Edward was in Hungary with King [[Andrew I of Hungary|Andrew I]], having left England as an infant after\n" +
                "his father's death and the accession of [[Canute the Great|Cnut]] as King of England.&lt;ref name=Huscroft8&gt;Huscroft\n" +
                "''Ruling England'' p. 8&lt;/ref&gt; In this mission Ealdred was somewhat successful and obtained insight into the\n" +
                "working of the German church during a stay of a year&lt;ref name=Walker76&gt;Walker ''Harold'' p. 76&lt;/ref&gt; with\n" +
                "[[Herman II (Archbishop of Cologne)|Hermann II]], the [[Archbishop of Cologne]].&lt;ref name=Edward215&gt;Barlow\n" +
                "''Edward the Confessor'' pp. 215&#8211;218&lt;/ref&gt; He also was impressed with the buildings he saw, and later\n" +
                "incorporated some of the German styles into his own constructions.&lt;ref name=King128&gt;King \"Ealdred\" ''Anglo-Norman\n" +
                "Studies XVIII'' p. 128&lt;/ref&gt; The main objective of the mission, however, was to secure the return of Edward; but\n" +
                "this failed, mainly because Henry III's relations with the Hungarians were strained, and the emperor was unable or\n" +
                "unwilling to help Ealdred.&lt;ref name=Mason88&gt;Mason ''House of Godwine'' p. 88&lt;/ref&gt; Ealdred was able to\n" +
                "discover that Edward was alive, and had a place at the Hungarian court.&lt;ref name=Rex126&gt;Rex ''Harold II'' p. 126&lt;/ref&gt;{{efn|Edward\n" +
                "eventually returned to England in 1057, but died shortly thereafter.&lt;ref name=Rex127&gt;Rex ''Harold II'' p. 127&lt;/ref&gt;}}\n" +
                "Although some sources state that Ealdred attended the coronation of Emperor [[Henry IV, Holy Roman Emperor|Henry IV]],\n" +
                "this is not possible, as on the date that Henry was crowned, Ealdred was in England consecrating an abbot.&lt;ref\n" +
                "name=King128/&gt; Ealdred had returned to England by 1055, and brought with him a copy of the ''[[Pontificale\n" +
                "Romano-Germanicum]]'', a [[Roman Pontifical|set of liturgies]], with him. An extant copy of this work, currently\n" +
                "manuscript [[Cotton library|Cotton Vitellus E xii]], has been identified as a copy owned by Ealdred.&lt;ref\n" +
                "name=King128/&gt; It appears likely that the ''[[Chrodegang of Metz|Rule of Chrodegang]]'', a continental set of\n" +
                "ordinances for the communal life of [[Canon (priest)|secular canons]], was introduced into England by Ealdred sometime\n" +
                "before 1059. Probably he brought it back from Germany, possibly in concert with Harold.&lt;ref name=Rex77&gt;Rex\n" +
                "''Harold II'' p. 77&lt;/ref&gt; After Ealdred's return to England he took charge of the sees of Hereford&lt;ref\n" +
                "name=Mason94&gt;Mason ''House of Godwine'' p. 94&lt;/ref&gt; and [[Bishop of Ramsbury (ancient)|Ramsbury]].&lt;ref\n" +
                "name=Harold132/&gt; Ealdred also administered [[Winchcombe Abbey]] and [[Gloucester Abbey]].&lt;ref name=Edward198&gt;Barlow\n" +
                "''Edward the Confessor'' pp. 197&#8211;199&lt;/ref&gt; The authors of the ''Handbook of British Chronology Third\n" +
                "Edition'' say he was named bishop of Hereford in 1056, holding the see until he resigned it in 1060,&lt;ref\n" +
                "name=Handbook217&gt;Fryde, et al. ''Handbook of British Chronology'' p. 217&lt;/ref&gt; but other sources say he merely\n" +
                "administered the see while it was vacant,&lt;ref name=Huscroft45&gt;Huscroft ''Ruling England'' p. 45&lt;/ref&gt; or\n" +
                "that he was bishop of Hereford from 1055 to 1060.&lt;ref name=BHOYork&gt;Greenway ''Fasti Ecclesiae Anglicanae 1066&#8211;1300:\n" +
                "Volume 6: York: Archbishops''&lt;/ref&gt; Ealdred became involved with the see of Ramsbury after its bishop [[Herman\n" +
                "(bishop)|Herman]] got into a dispute with King Edward over the movement of the seat of his bishopric to [[Malmesbury\n" +
                "Abbey]]. Herman wished to move the seat of his see, but Edward refused permission for the move. Ealdred was a close\n" +
                "associate of Herman's,&lt;ref name=King128/&gt; and the historian [[H. R. Loyn]] called Herman \"something of an alter\n" +
                "ego\" to Ealdred.&lt;ref name=Loyn61&gt;Loyn ''English Church'' p. 61&lt;/ref&gt; According to the medieval chronicler\n" +
                "[[John of Worcester]], Ealdred was given the see of Ramsbury to administer while Herman remained outside England. Herman\n" +
                "returned in 1058, and resumed his bishopric. There is no contemporary documentary evidence of Ealdred's administration\n" +
                "of Ramsbury.&lt;ref name=King128/&gt; ==Welsh affairs, Jerusalem, and Worcester== The king again employed Ealdred as a\n" +
                "diplomat in 1056, when he assisted earls Harold and Leofric in negotiations with the Welsh.&lt;ref name=King128a/&gt;\n" +
                "Edward sent Ealdred after the death in battle of Bishop [[Leofgar of Hereford]], who had attacked Gruffydd ap Llywelyn\n" +
                "after encouragement from the king. However, Leofgar lost the battle and his life, and Edward had to sue for peace.&lt;ref\n" +
                "name=Maund94&gt;Maund ''Welsh Kings'' pp. 94&#8211;95&lt;/ref&gt; Although details of the negotiations are lacking,\n" +
                "Gruffydd ap Llywelyn swore loyalty to King Edward,&lt;ref name=King128a/&gt; but the oath may not have had any\n" +
                "obligations on Gruffydd's part to Edward. The exact terms of the submission are not known in total, but Gruffydd was not\n" +
                "required to assist Edward in war nor attend Edward's court.&lt;ref name=Maund94/&gt; Ealdred was rewarded with the\n" +
                "administration of the see of Hereford, which he held until 1061, and was appointed Archbishop of York.&lt;ref\n" +
                "name=King128a&gt;King \"Ealdred\" ''Anglo-Norman Studies XVIII'' pp. 128&#8211;129&lt;/ref&gt; The diocese had suffered a\n" +
                "serious raid from the Welsh in 1055, and during his administration, Ealdred continued the rebuilding of the cathedral\n" +
                "church as well as securing the cathedral chapter's rights.&lt;ref name=King128a/&gt; Ealdred was granted the\n" +
                "administration in order that the area might have someone with experience with the Welsh in charge.&lt;ref\n" +
                "name=Darlington399/&gt; In 1058 Ealdred made a pilgrimage to [[Jerusalem]], the first English bishop to make the\n" +
                "journey.&lt;ref name=Edward208/&gt; He travelled through Hungary, and the ''[[Anglo-Saxon Chronicle]]'' said that \"he\n" +
                "went to Jerusalem in such state as no-one had done before him\".&lt;ref name=QKing130&gt;Quoted in King \"Ealdred\"\n" +
                "''Anglo-Norman Studies XVIII'' p. 130&lt;/ref&gt; While in Jerusalem he made a gift of a gold chalice to the [[church of\n" +
                "the Holy Sepulchre]].&lt;ref name=BarlowChurch89&gt;Barlow ''English Church 1000&#8211;1066'' p. 89&lt;/ref&gt; It is\n" +
                "possible that the reason Ealdred travelled through Hungary was to arrange the travel of Edward the Exile's family to\n" +
                "England. Another possibility is that he wished to search for other possible heirs to King Edward in Hungary.&lt;ref\n" +
                "name=King130&gt;King \"Ealdred\" ''Anglo-Norman Studies XVIII'' p. 130&lt;/ref&gt; It is not known exactly when Edward the\n" +
                "Exile's family returned to England, whether they returned with Edward in 1057, or sometime later, so it is only a\n" +
                "possibility that they returned with Ealdred in 1058.&lt;ref name=Rex129&gt;Rex ''Harold II'' p. 129&lt;/ref&gt; Very\n" +
                "little documentary evidence is available from Ealdred's time as Bishop of Worcester. Only five leases that he signed\n" +
                "survive, and all date from 1051 to 1053. Two further leases exist in ''[[Hemming's Cartulary]]'' as copies only. How the\n" +
                "[[Anglican Diocese of Worcester|diocese of Worcester]] was administered when Ealdred was abroad is unclear, although it\n" +
                "appears that [[Wulfstan (Bishop of Worcester)|Wulfstan]], the prior of the [[cathedral chapter]], performed the\n" +
                "religious duties in the diocese. On the financial side, the ''[[Chronicon Abbatiae de Evesham|Evesham Chronicle]]''\n" +
                "states that [[&#198;thelwig]], who became abbot of [[Evesham Abbey]] in 1058, administered Worcester before he became\n" +
                "abbot.&lt;ref name=King134&gt;King \"Ealdred\" ''Anglo-Norman Studies XVIII'' pp. 134&#8211;137&lt;/ref&gt; ==Archbishop\n" +
                "of York== [[File:Bayeux Edward Funeral.jpg|left|upright=2.4|thumb|The funeral cortege of Edward the Confessor, from the\n" +
                "[[Bayeux Tapestry]]|alt=Tapestry image of a procession of men carrying a coffin heading towards a church building.]]\n" +
                "Cynesige, the archbishop of York, died on 22 December 1060, and Ealdred was elected [[Archbishop of York]] on Christmas\n" +
                "Day, 1060. Although a bishop was promptly appointed to Hereford, none was named to Worcester, and it appears that\n" +
                "Ealdred intended to retain Worcester along with York, which several of his predecessors had done.&lt;ref name=King130/&gt;\n" +
                "There were a few reasons for this, one of which was political, as the kings of England preferred to appoint bishops from\n" +
                "the south to the northern bishoprics, hoping to counter the northern tendency towards separatism. Another reason was\n" +
                "that York was not a wealthy see, and Worcester was. Holding Worcester along with York allowed the archbishop sufficient\n" +
                "revenue to support himself.&lt;ref name=Loyn158&gt;Loyn ''Governance'' p. 158&lt;/ref&gt; In 1061 Ealdred travelled to\n" +
                "Rome to receive the [[pallium]], the symbol of an archbishop's authority. Journeying with him was [[Tostig\n" +
                "Godwinson|Tostig]], another son of Earl Godwin, who was now earl of [[Northumbria]].&lt;ref name=Hindley330&gt;Hindley\n" +
                "''Brief History of the Anglo-Saxons'' p. 330&lt;/ref&gt; William of Malmesbury says that Ealdred, by \"amusing the\n" +
                "simplicity of King Edward and alleging the custom of his predecessors, had acquired, more by bribery than by reason, the\n" +
                "archbishopric of York while still holding his former see.\"&lt;ref name=Powell13&gt;Powell and Wallis ''House of Lords''\n" +
                "pp. 13&#8211;14&lt;/ref&gt; On his arrival in Rome, however, charges of [[simony]], or the buying of ecclesiastical\n" +
                "office, and lack of learning were brought against him, and his elevation to York was refused by [[Pope Nicholas II]],\n" +
                "who also deposed him from Worcester.&lt;ref name=Powell13/&gt; The story of Ealdred being deposed comes from the ''Vita\n" +
                "Edwardi'', a life of Edward the Confessor, but the ''Vita Wulfstani'', an account of the life of Ealdred's successor at\n" +
                "Worcester, [[Wulfstan (Bishop of Worcester)|Wulfstan]], says that Nicholas refused the pallium until a promise to find a\n" +
                "replacement for Worcester was given by Ealdred.&lt;ref name=King131&gt;King \"Ealdred\" ''Anglo-Norman Studies XVIII'' p.\n" +
                "131&lt;/ref&gt; Yet another chronicler, John of Worcester, mentions nothing of any trouble in Rome, and when discussing\n" +
                "the appointment of Wulfstan, says that Wulfstan was elected freely and unanimously by the clergy and people.&lt;ref\n" +
                "name=King131/&gt; John of Worcester also claims that at Wulfstan's consecration, [[Stigand]], the archbishop of\n" +
                "Canterbury extracted a promise from Ealdred that neither he nor his successors would lay claim to any jurisdiction over\n" +
                "the diocese of Worcester. Given that John of Worcester wrote his chronicle after the eruption of the Canterbury&#8211;York\n" +
                "supremacy struggle, the story of Ealdred renouncing any claims to Worcester needs to be considered suspect.&lt;ref\n" +
                "name=King131a&gt;King \"Ealdred\" ''Anglo-Norman Studies XVIII'' pp. 131&#8211;132&lt;/ref&gt; For whatever reason,\n" +
                "Ealdred gave up the see of Worcester in 1062, when papal legates arrived in England to hold a council and make sure\n" +
                "Ealdred relinquished Worcester.&lt;ref name=Harold50&gt;Walker ''Harold'' p. 50&lt;/ref&gt; This happened at Easter in\n" +
                "1062.&lt;ref name=Darlington399&gt;Darlington \"Ecclesiastical Reform\" ''English Historical Review'' pp. 399&#8211;400&lt;/ref&gt;\n" +
                "Ealdred was succeeded by Wulfstan, chosen by Ealdred, but John of Worcester relates that Ealdred had a hard time\n" +
                "deciding between Wulfstan and &#198;thelwig.&lt;ref name=Monastic76&gt;Knowles ''Monastic Order'' p. 76&lt;/ref&gt; The\n" +
                "legates had urged the selection of Wulfstan because of his saintliness.&lt;ref name=BarlowChurch106&gt;Barlow ''English\n" +
                "Church 1000&#8211;1066'' pp. 106&#8211;107&lt;/ref&gt; Because the position of Stigand, the archbishop of Canterbury,\n" +
                "was irregular, Wulfstan sought and received consecration as a bishop from Ealdred. Normally, Wulfstan would have gone to\n" +
                "the archbishop of Canterbury, as the see of Worcester was within Canterbury's province.&lt;ref name=Brooks306&gt;Brooks\n" +
                "''Early History of the Church of Canterbury'' p. 306&lt;/ref&gt; Although Ealdred gave up the bishopric, the appointment\n" +
                "of Wulfstan was one that allowed Ealdred to continue his considerable influence on the see of Worcester. Ealdred\n" +
                "retained a number of estates belonging to Worcester. Even after the Norman Conquest, Ealdred still controlled some\n" +
                "events in Worcester, and it was Ealdred, not Wulfstan, who opposed [[Urse d'Abetot]]'s attempt to extend the castle of\n" +
                "Worcester into the cathedral after the Norman Conquest.&lt;ref name=King132&gt;King \"Ealdred\" ''Anglo-Norman Studies\n" +
                "XVIII'' pp. 132&#8211;133&lt;/ref&gt; While archbishop, Ealdred built at [[Beverley]], expanding on the building\n" +
                "projects begun by his predecessor Cynesige,&lt;ref name=Huscroft46&gt;Huscroft ''Ruling England'' p. 46&lt;/ref&gt; as\n" +
                "well as repairing and expanding other churches in his diocese.&lt;ref name=Edward198/&gt; He also built refectories for\n" +
                "the canons at York and Southwell.&lt;ref name=Darlington404&gt;Darlington \"Ecclesiastical Reform\" ''English Historical\n" +
                "Review'' p. 404&lt;/ref&gt; He also was the one bishop that published ecclesiastical legislation during Edward the\n" +
                "Confessor's reign, attempting to discipline and reform the clergy.&lt;ref name=Barlow122&gt;Barlow ''English Church,\n" +
                "1066&#8211;1154'' p. 122&lt;/ref&gt; He held a synod of his clergy shortly before 1066.&lt;ref name=BarlowChurch246&gt;Barlow\n" +
                "''English Church 1000&#8211;1066'' p. 246&lt;/ref&gt; ==After the death of Edward the Confessor== [[File:William the\n" +
                "Conqueror silver coin.jpg|thumb|right|A penny from the time of William I|alt=Coin image of a crowned male head with a\n" +
                "sceptre in the background]] John of Worcester, a medieval chronicler, stated that Ealdred crowned King Harold II in\n" +
                "1066, although the [[Normans|Norman]] chroniclers mention Stigand as the officiating prelate.&lt;ref name=Hindley335/&gt;\n" +
                "Given Ealdred's known support of Godwin's family, John of Worcester is probably correct.&lt;ref name=DNB/&gt; Stigand's\n" +
                "position as archbishop was canonically suspect, and as earl Harold had not allowed Stigand to consecrate one of the\n" +
                "earl's churches, it is unlikely that Harold would have allowed Stigand to perform the much more important royal\n" +
                "coronation.&lt;ref name=Rex199&gt;Rex ''Harold'' pp. 199&#8211;200&lt;/ref&gt; Arguments for Stigand having performed\n" +
                "the coronation, however, rely on the fact that no other English source names the ecclesiastic who performed the\n" +
                "ceremony; all Norman sources name Stigand as the presider.&lt;ref name=BarlowChurch60&gt;Barlow ''English Church 1000&#8211;1066''\n" +
                "p. 60 footnote 4&lt;/ref&gt; In all events, Ealdred and Harold were close, and Ealdred supported Harold's bid to become\n" +
                "king.&lt;ref name=Harold132/&gt;&lt;ref name=Harold117&gt;Walker ''Harold'' p. 117&lt;/ref&gt; Ealdred perhaps\n" +
                "accompanied Harold when the new king went to York and secured the support of the northern magnates shortly after\n" +
                "Harold's consecration.&lt;ref name=Douglas183&gt;Douglas ''William the Conqueror'' p. 183&lt;/ref&gt; According to the\n" +
                "medieval chronicler [[Geoffrey Gaimar]], after the [[Battle of Stamford Bridge]] Harold entrusted the loot gained from\n" +
                "[[Harald III of Norway|Harold Hardrada]] to Ealdred.&lt;ref name=Lawson42n93&gt;Lawson ''Battle of Hastings'' p. 42\n" +
                "footnote 93&lt;/ref&gt; Gaimar asserts that King Harold did this because he had heard of Duke William's landing in\n" +
                "England, and needed to rush south to counter it.&lt;ref name=Lawson75&gt;Lawson ''Battle of Hastings'' p. 75&lt;/ref&gt;\n" +
                "After the Battle of Hastings, Ealdred joined the group who tried to elevate Edgar the &#198;theling, Edward the Exile's\n" +
                "son, as king, but eventually he submitted to William the Conqueror at [[Berkhamsted]].&lt;ref name=Huscroft19&gt;Huscroft\n" +
                "''Ruling England'' p. 19&lt;/ref&gt;&lt;ref name=Williams32&gt;Williams ''English and the Norman Conquest'' p. 32&lt;/ref&gt;\n" +
                "John of Worcester says that the group supporting Edgar vacillated over what to do while William ravaged the countryside,&lt;ref\n" +
                "name=Rex130&gt;Rex ''Harold II'' p. 130&lt;/ref&gt; which led to Ealdred and Edgar's submission to William.&lt;ref\n" +
                "name=Douglas206&gt;Douglas ''William the Conqueror'' p. 206&lt;/ref&gt; Ealdred crowned William king on\n" +
                "[[Christmas|Christmas Day]] 1066.&lt;ref name=Powell1&gt;Powell and Wallis ''House of Lords'' p. 1&lt;/ref&gt; An\n" +
                "innovation in William's coronation ceremony was that before the actual crowning, Ealdred asked the assembled crowd, in\n" +
                "English, if it was their wish that William be crowned king. The [[Roman Catholic Diocese of Coutances|Bishop of\n" +
                "Coutances]] then did the same, but in [[Norman language|Norman French]].&lt;ref name=Powell1/&gt; In March 1067, William\n" +
                "took Ealdred with him when William returned to [[Normandy]], along with the other English leaders Earl [[Edwin, Earl of\n" +
                "Mercia|Edwin of Mercia]], Earl [[Morcar]], Edgar the &#198;theling, and Archbishop Stigand.&lt;ref name=Harold185&gt;Walker\n" +
                "''Harold'' pp. 185&#8211;187&lt;/ref&gt; Ealdred at [[Whitsun]] 1068 performed the coronation of [[Matilda of\n" +
                "Flanders|Matilda]], William's wife.&lt;ref name=Powell13/&gt; The ''[[Laudes Regiae]]'', or song commending a ruler,\n" +
                "that was performed at Matilda's coronation may have been composed by Ealdred himself for the occasion.&lt;ref\n" +
                "name=Queen183&gt;Stafford ''Queen Emma &amp; Queen Edith'' p. 183&lt;/ref&gt; In 1069, when the northern [[thegn]]s\n" +
                "rebelled against William and attempted to install Edgar the &#198;theling as king, Ealdred continued to support William.&lt;ref\n" +
                "name=Williams32/&gt; He was the only northern leader to support William, however.&lt;ref name=Kapelle109&gt;Kapelle\n" +
                "''Norman Conquest of the North'' p. 109&lt;/ref&gt; Ealdred was back at York by 1069. He died there on 11 September\n" +
                "1069,&lt;ref name=Handbook224/&gt; and his body was buried in his episcopal cathedral. He may have taken an active part\n" +
                "in trying to calm the rebellions in the north in 1068 and 1069.&lt;ref name=Powell13/&gt; The medieval chronicler\n" +
                "William of Malmesbury records a story that when the new sheriff of Worcester, Urse d'Abetot, encroached on the cemetery\n" +
                "of the cathedral chapter for [[Worcester Cathedral]], Ealdred pronounced a rhyming curse on him, saying \"Thou are called\n" +
                "Urse. May you have God's curse.\"&lt;ref name=QBates153&gt;Quoted in Bates ''William the Conqueror'' p. 153. The exact\n" +
                "sentence in Bates is \"Urse's refusal to move it drew a poetic Old English curse from the archbishop, which began \"Thou\n" +
                "are called Urse. May you have God's curse.\"\"&lt;/ref&gt; ==Legacy== After Ealdred's death, one of the restraints on\n" +
                "William's treatment of the English was removed.&lt;ref name=Barlow57/&gt; Ealdred was one of a few native Englishmen who\n" +
                "William appears to have trusted, and his death led to fewer attempts to integrate Englishmen into the administration,\n" +
                "although such efforts did not entirely stop.&lt;ref name=Bates156&gt;Bates ''William the Conqueror'' p. 156&lt;/ref&gt;\n" +
                "In 1070, a church council was held at Westminster and a number of bishops were deposed. By 1073 there were only two\n" +
                "Englishmen in episcopal sees, and by the time of William's death in 1087, there was only one, Wulfstan II of Worcester.&lt;ref\n" +
                "name=Barlow57&gt;Barlow ''English Church, 1066&#8211;1154'' p. 57&lt;/ref&gt; Ealdred did much to restore discipline in\n" +
                "the monasteries and churches under his authority,&lt;ref name=DNB/&gt;&lt;ref name=Barlow122/&gt; and was liberal with\n" +
                "gifts to the churches of his diocese. He built the monastic church of St Peter at [[Gloucester]] (now [[Gloucester\n" +
                "Cathedral]], though nothing of his fabric remains), then part of his diocese of Worcester. He also repaired a large part\n" +
                "of [[Beverley Minster]] in the diocese of York, adding a [[Presbytery (architecture)|presbytery]] and an unusually\n" +
                "splendid painted ceiling covering \"all the upper part of the church from the choir to the tower{{nbsp}}...intermingled\n" +
                "with gold in various ways, and in a wonderful fashion\".&lt;ref&gt;Dodwell ''Anglo-Saxon Art'' p. 93, quoting the\n" +
                "''Chronica Ecclesiae Eboracensis'' (York chronicle). None of these works remain.&lt;/ref&gt; He added a pulpit \"in\n" +
                "German style\" of bronze, gold and silver, surmounted by an arch with a [[rood]] cross in the same materials; these were\n" +
                "examples of the lavish decorations added to important churches in the years before the conquest.&lt;ref name=Edward198/&gt;&lt;ref&gt;Dodwell\n" +
                "''Anglo-Saxon Art'' p. 65 and note 151 on pp. 264&#8211;265&lt;/ref&gt; Ealdred encouraged Folcard, a monk of\n" +
                "[[Canterbury Cathedral|Canterbury]], to write the ''Life'' of Saint [[John of Beverley]].&lt;ref name=DNBJB&gt;Palliser\n" +
                "\"John of Beverley (St John of Beverley) (d. 721)\" ''Oxford Dictionary of National Biography''&lt;/ref&gt; This was part\n" +
                "of Ealdred's promotion of the cult of Saint John,&lt;ref name=Blair314&gt;Blair ''Church in Anglo-Saxon Society'' p. 314&lt;/ref&gt;\n" +
                "who had only been canonised in 1037. Along with the ''Pontificale'', Ealdred may have brought back from Cologne the\n" +
                "first manuscript of the ''[[Cambridge Songs]]'' to enter England, a collection of Latin [[Goliard]]ic songs which became\n" +
                "famous in the Middle Ages.&lt;ref name=ASEnc&gt;Lapidge \"Ealdred\" ''Blackwell Encyclopedia of Anglo-Saxon England'' p.\n" +
                "153&lt;/ref&gt; The historian Michael Lapidge suggests that the ''Laudes Regiae'', which are included in Cotton\n" +
                "Vitellius E xii, might have been composed by Ealdred, or a member of his household. Another historian, H. J. Cowdrey,\n" +
                "argued that the ''laudes'' were composed at Winchester. These praise songs are probably the same performed at Matilda's\n" +
                "coronation, but might have been used at other court ceremonies before Ealdred's death.&lt;ref name=Cotton16&gt;Lapidge\n" +
                "\"Ealdred of York\" ''Yorkshire Archaeological Journal'' pp. 16&#8211;18&lt;/ref&gt; Historians have seen Ealdred as an\n" +
                "\"old-fashioned prince-bishop\".&lt;ref name=Loyn62&gt;Loyn ''English Church'' p. 62&lt;/ref&gt; Others say he \"raised the\n" +
                "see of York from its former rustic state\".&lt;ref name=QHarper168&gt;Harper-Bill \"Anglo-Norman Church\" ''Companion to\n" +
                "the Anglo-Norman World'' p. 158&lt;/ref&gt; He was known for his generosity and for his diplomatic and administrative\n" +
                "abilities.&lt;ref name=Loyn62/&gt; After the Conquest, Ealdred provided a degree of continuity between the pre- and\n" +
                "post-Conquest worlds.&lt;ref name=Loyn67&gt;Loyn ''English Church'' p. 67&lt;/ref&gt; One modern historian feels that it\n" +
                "was Ealdred who was behind the compilation of the D version of the ''Anglo-Saxon Chronicle'', and gives a date in the\n" +
                "1050s as its composition.&lt;ref name=Lawson62fn34&gt;Lawson ''Battle of Hastings'' p. 62 footnote 34&lt;/ref&gt;\n" +
                "Certainly, Ealdred is one of the leading figures in the work, and it is likely that one of his clerks compiled the\n" +
                "version.&lt;ref name=Wormald130&gt;Wormald ''Making of English Law'' pp. 130&#8211;131&lt;/ref&gt; ==Notes==\n" +
                "{{notelist}} ==Citations== {{reflist}} ==References== {{refbegin}} * {{cite book |author=Barlow, Frank |authorlink=Frank\n" +
                "Barlow (historian) |title=Edward the Confessor |publisher=University of California Press |location=Berkeley, CA\n" +
                "|year=1970 |isbn=0-520-01671-8}} * {{cite book |author=Barlow, Frank |authorlink=Frank Barlow (historian) |title=The\n" +
                "English Church 1000&#8211;1066: A History of the Later Anglo-Saxon Church |publisher=Longman |location=New York\n" +
                "|year=1979 |isbn=0-582-49049-9 |edition=Second }} * {{cite book |author=Barlow, Frank |authorlink=Frank Barlow\n" +
                "(historian) |title=The English Church 1066&#8211;1154: A History of the Anglo-Norman Church |publisher=Longman\n" +
                "|location=New York |year=1979|isbn=0-582-50236-5}} * {{cite book |author=Barlow, Frank |authorlink=Frank Barlow\n" +
                "(historian) |title=The Godwins: The Rise and Fall of a Noble Dynasty |publisher=Pearson/Longman |location=London\n" +
                "|year=2003 |isbn=0-582-78440-9 }} * {{cite book |author=Bates, David |authorlink=David Bates (historian) |title=William\n" +
                "the Conqueror |publisher=Tempus |location=Stroud, UK |year=2001 |isbn=0-7524-1980-3}} * {{cite book |author=Blair, John\n" +
                "P. |title=The Church in Anglo-Saxon Society |publisher=Oxford University Press |location=Oxford, UK |year= 2005\n" +
                "|isbn=0-19-921117-5 }} * {{cite book |author=Brooks, Nicholas |authorlink=Nicholas Brooks |title=The Early History of\n" +
                "the Church of Canterbury: Christ Church from 597 to 1066 |publisher=Leicester University Press |location=London\n" +
                "|year=1984 |isbn=0-7185-0041-5 }} * {{cite journal |author=Darlington, R. R. |title=Ecclesiastical Reform in the Late\n" +
                "Old English Period |journal=[[The English Historical Review]] |volume=51 |issue=203 |date= July 1936 |pages= 385&#8211;428\n" +
                "|jstor= 553127 |doi=10.1093/ehr/LI.CCIII.385}} * {{cite book |author=Dodwell, C.R. |title=Anglo-Saxon Art, A New\n" +
                "Perspective|year= 1982 |publisher= Manchester University Press|location=Manchester, UK| isbn=0-7190-0926-X}} * {{cite\n" +
                "book |author= Douglas, David C. |authorlink= David C. Douglas |title= William the Conqueror: The Norman Impact Upon\n" +
                "England|year=1964 |publisher= University of California Press |location= Berkeley, CA |oclc= 399137 }} * {{cite book\n" +
                "|author=Fleming, Robin |authorlink=Robin Fleming |title=Kings &amp; Lords in Conquest England |year=2004\n" +
                "|edition=Reprint |publisher=Cambridge University Press |location=Cambridge, UK |isbn=0-521-52694-9}} * {{cite book\n" +
                "|author1=Fryde, E. B. |author2=Greenway, D. E. |author3=Porter, S. |author4=Roy, I. |title=Handbook of British\n" +
                "Chronology|edition=Third revised |publisher=Cambridge University Press |location=Cambridge, UK |year=1996\n" +
                "|isbn=0-521-56350-X }} * {{cite book |author= Greenway, Diana E. |title= Fasti Ecclesiae Anglicanae 1066&#8211;1300:\n" +
                "Volume 6: York: Archbishops |year= 1999 |publisher= Institute of Historical Research |url=\n" +
                "http://british-history.ac.uk/report.aspx?compid=8457 |accessdate= 2 February 2009 |archive-url=\n" +
                "https://web.archive.org/web/20110809060617/http://british-history.ac.uk/report.aspx?compid=8457 |archive-date= 9 August\n" +
                "2011 |url-status= dead |df= dmy-all }} * {{cite encyclopedia |author=Harper-Bill, Christopher |title=The Anglo-Norman\n" +
                "Church |encyclopedia=A Companion to the Anglo-Norman World |pages=165&#8211;190 |editor1=Harper-Bill, Christopher\n" +
                "|editor2=van Houts, Elizabeth |publisher=Boydell |location=Woodbridge, UK |year=2002 |isbn=978-1-84383-341-3}} * {{cite\n" +
                "book |author= Hindley, Geoffrey |title=A Brief History of the Anglo-Saxons: The Beginnings of the English Nation |year=\n" +
                "2006|publisher= Carroll &amp; Graf Publishers |location=New York |isbn=978-0-7867-1738-5}} * {{cite book\n" +
                "|author=Huscroft, Richard |title=Ruling England 1042&#8211;1217 |publisher=Pearson/Longman |location=London |year=2005\n" +
                "|isbn=0-582-84882-2 }} * {{cite book |author=Kapelle, William E. |authorlink= William E. Kapelle |title=The Norman\n" +
                "Conquest of the North: The Region and Its Transformation |publisher=University of North Carolina Press |location=Chapel\n" +
                "Hill, NC |year=1979 |isbn=0-8078-1371-0}} * {{cite encyclopedia |author=King, Vanessa |title=Ealdred, Archbishop of\n" +
                "York: The Worcester Years |encyclopedia=Anglo-Norman Studies XVIII: Proceedings of the Battle Conference 1995 |year=1996\n" +
                "|publisher=Boydell |location=Woodbridge, UK |editor=Harper-Bill, Christopher |pages=124&#8211;137| isbn=0-85115-666-5}}\n" +
                "* {{cite book |author=Knowles, David |authorlink=David Knowles (scholar) |title=The Monastic Order in England: A History\n" +
                "of its Development from the Times of St. Dunstan to the Fourth Lateran Council, 940&#8211;1216 |publisher=Cambridge\n" +
                "University Press |location=Cambridge, UK |year=1976 |edition= Second reprint |isbn=0-521-05479-6}} * {{cite encyclopedia\n" +
                "|author=Lapidge, Michael |authorlink=Michael Lapidge |title=Ealdred |encyclopedia=The Blackwell Encyclopaedia of\n" +
                "Anglo-Saxon England |editor1=Lapidge, Michael |editor1-link=Michael Lapidge |editor2=Blair, John |editor3=Keynes, Simon\n" +
                "|editor-link3= Simon Keynes |editor4= Scragg, Donald |year=2001 |publisher=Blackwell Publishing |location=Malden, MA\n" +
                "|isbn=978-0-631-22492-1 |page=153}} * {{cite journal|author=Lapidge, Michael |authorlink=Michael Lapidge\n" +
                "|year=1983|title= Ealdred of York and MS. Cotton Vitellius E.XII |journal =Yorkshire Archaeological Journal | volume=55\n" +
                "|pages=11&#8211;25}} * {{cite book |author=Lawson, M. K. |title=The Battle of Hastings: 1066 |publisher=Tempus\n" +
                "|location=Stroud, UK |year=2002 |isbn=0-7524-1998-6 }} * {{cite book |author=Lawson, M. K. |title= Cnut: England's\n" +
                "Viking King |publisher=Tempus Publishing, Limited |location=Stroud, UK |year=2000 |isbn=0-7524-2964-7}} * {{cite\n" +
                "encyclopedia |author=Lawson, M. K. |encyclopedia=Oxford Dictionary of National Biography |title= Ealdred (d. 1069) |url=\n" +
                "http://www.oxforddnb.com/view/article/37382 |accessdate= 11 November 2007 |doi= 10.1093/ref:odnb/37382 |year=2004\n" +
                "|publisher=Oxford University Press}} {{ODNBsub}} * {{cite book |author=Loyn, H. R. |authorlink= H. R. Loyn|title=The\n" +
                "English Church, 940&#8211;1154 |publisher=Pearson Education |location=Upper Saddle River, NJ |year=2000\n" +
                "|isbn=0-582-30303-6}} * {{cite book |author=Loyn, H. R. |authorlink= H. R. Loyn |title=The Governance of Anglo-Saxon\n" +
                "England, 500&#8211;1087 |publisher=Stanford University Press |location=Stanford, CA |year=1984 |isbn=0-8047-1217-4}} *\n" +
                "{{cite book |author=Mason, Emma |title=House of Godwine: The History of Dynasty |publisher=Hambledon &amp; London\n" +
                "|location=London |year=2004 |isbn=1-85285-389-1 }} * {{cite book |author=Maund, Kari L. |title=The Welsh Kings:\n" +
                "Warriors, Warlords and Princes |publisher=Tempus |location=Stroud, UK |year=2006 |isbn=0-7524-2973-6}} * {{cite\n" +
                "encyclopedia |author= Palliser, D. M. |title = John of Beverley (St John of Beverley) (d. 721) |encyclopedia= Oxford\n" +
                "Dictionary of National Biography |publisher= Oxford University Press |year= 2004\n" +
                "|url=http://www.oxforddnb.com/view/article/14845|accessdate= 29 September 2008 |doi= 10.1093/ref:odnb/14845}}\n" +
                "{{ODNBsub}} * {{cite book |author1= Powell, J. Enoch |authorlink1= Enoch Powell |author2=Wallis, Keith|title= The House\n" +
                "of Lords in the Middle Ages: A History of the English House of Lords to 1540 |year=1968 |publisher= Weidenfeld and\n" +
                "Nicolson |location=London|oclc= 463626 }} * {{cite book |author=Rex, Peter |title=Harold II: The Doomed Saxon King\n" +
                "|publisher=Tempus |location=Stroud, UK |year=2005 |isbn=978-0-7394-7185-2}} * {{cite journal |author1=Smith, Mary\n" +
                "Frances |author2=Fleming, Robin |author3=Halpin, Patricia | title=Court and Piety in Late Anglo-Saxon England | journal=\n" +
                "The Catholic Historical Review |number=4| date=October 2001 |pages=569&#8211;602 | doi=10.1353/cat.2001.0189 | volume=87\n" +
                "|jstor= 25026026}} * {{cite book |author=Stafford, Pauline |authorlink=Pauline Stafford |title=Queen Emma and Queen\n" +
                "Edith: Queenship and Women's Power in Eleventh-century England |publisher=Blackwell Publishers |location=Cambridge, MA\n" +
                "|year=1997 |isbn=0-631-22738-5 }} * {{cite book |author=Walker, Ian |title=Harold the Last Anglo-Saxon King\n" +
                "|publisher=Wrens Park |location=Gloucestershire, UK |year=2000|isbn=0-905778-46-4}} * {{cite book |author=Williams, Ann\n" +
                "|authorlink= Ann Williams (historian) |title=The English and the Norman Conquest |publisher=Boydell Press\n" +
                "|location=Ipswich, UK |year=2000 |isbn=0-85115-708-4}} * {{cite book |author=Wormald, Patrick |authorlink=Patrick\n" +
                "Wormald |title=The Making of English Law: King Alfred to the Twelfth Century |publisher=Blackwell Publishers\n" +
                "|location=Cambridge, MA |year=1999 |isbn=0-631-22740-7}} {{refend}} ==Further reading== {{refbegin}} * {{cite\n" +
                "encyclopedia | author=Nelson, Janet L. |year =1981| title =The Rites of the Conqueror|encyclopedia= Anglo-Norman Studies\n" +
                "IV: Proceedings of the Battle Conference on Anglo-Norman Studies |editor=R. Allen Brown |publisher = Boydell Press\n" +
                "|location=Woodbridge, UK |isbn=0-85115-161-2 |pages=117&#8211;132; 210&#8211;221}} * {{cite journal| author=Tinti,\n" +
                "Francesca |title=The Pallium Privilege of Pope Nicholas II for Archbishop Ealdred of York |journal=The Journal of\n" +
                "Ecclesiastical History |volume=70 |issue=4 |pages=708&#8211;730 |year=2019 |doi=10.1017/S0022046919000630 }} {{refend}}\n" +
                "==External links== * {{PASE|12449|Ealdred 37}} {{s-start}} {{s-rel|ca}} {{s-bef | before=[[Lyfing of Winchester|Lyfing]]\n" +
                "}} {{s-ttl| title=[[Abbot of Tavistock]] | years=1027&#8211;43}} {{s-aft| after=Sihtric}} {{s-bef | before=[[Leofgar of\n" +
                "Hereford]] }} {{s-ttl| title=[[Bishop of Hereford]] | years=1056&#8211;1060}} {{s-aft| after=[[Walter of Lorraine]] }}\n" +
                "{{s-bef | before=[[Lyfing of Winchester|Lyfing]] }} {{s-ttl| title=[[Bishop of Worcester]] | years=1046&#8211;1062}}\n" +
                "{{s-aft| after=[[Wulfstan (Bishop of Worcester)|Wulfstan]] }} {{s-bef | before=[[Cynesige]] }} {{s-ttl|\n" +
                "title=[[Archbishop of York]] | years=1061&#8211;1069}} {{s-aft| after=[[Thomas of Bayeux]]}} {{s-end}} {{Archbishops of\n" +
                "York}} {{Bishops of Hereford}} {{Bishops of Worcester}} {{featured article}} {{Use dmy dates|date=July 2013}} {{Use\n" +
                "British English|date=June 2013}} {{Authority control}} {{DEFAULTSORT:Ealdred}} [[Category:1069 deaths]]\n" +
                "[[Category:Abbots of Tavistock]] [[Category:Archbishops of York]] [[Category:Bishops of Hereford]] [[Category:Bishops of\n" +
                "Worcester]] [[Category:11th-century Roman Catholic bishops]] [[Category:11th-century Roman Catholic archbishops]]\n" +
                "[[Category:Year of birth unknown]] [[Category:Burials at York Minster]]";
        Pattern pattern =  Pattern.compile("\\[\\[(Category:.+?)\\]\\]");
        Matcher matcher = pattern.matcher(abc);
        while(matcher.find()){
            String group = matcher.group(1);
            String[] split = group.split(":");
            System.out.println(split[1]);
        }
    }
}
