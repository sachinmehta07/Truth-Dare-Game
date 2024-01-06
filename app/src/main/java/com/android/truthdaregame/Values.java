package com.android.truthdaregame;

public class Values {

    public static final String CATEGORY_FUNNY = "funny";
    public static final String CATEGORY_EMBARRASSING = "embarrassing";
    public static final String CATEGORY_CHALLENGING = "challenging";
    public static final String CATEGORY_RANDOM = "random";

    TruthItem[] truths = new TruthItem[]{
            new TruthItem("What does your dream boy or girl look like?", CATEGORY_FUNNY),
            new TruthItem("Would you rather live with no internet or no A/C or heating?", CATEGORY_FUNNY),
            new TruthItem("If you could go back in time and erase one thing you said or did, what would it be?", CATEGORY_CHALLENGING),
            new TruthItem("Have you ever waved at someone thinking they saw you when really they didn't? What did you do when you realized it?", CATEGORY_FUNNY),
            new TruthItem("Describe the strangest dream you've ever had. Did you like it?", CATEGORY_CHALLENGING),
            new TruthItem("The world ends next week, and you can do anything you want (even if it's illegal). What would you do?", CATEGORY_CHALLENGING),
            new TruthItem("How far would you go to land the guy or girl of your dreams?", CATEGORY_CHALLENGING),
            new TruthItem("What is the most childish thing that you still do?", CATEGORY_CHALLENGING),
            new TruthItem("Tell us a joke that never fails to make you laugh.", CATEGORY_CHALLENGING),
            new TruthItem("If you could trade lives with any fictional character, who would it be?", CATEGORY_CHALLENGING),
            // Additional Truths - Funny
            new TruthItem("If you were a cartoon character, what catchphrase would you have?", CATEGORY_FUNNY),
            new TruthItem("Share a funny childhood memory that still makes you laugh.", CATEGORY_FUNNY),
            new TruthItem("If you could have dinner with any comedian, dead or alive, who would it be?", CATEGORY_FUNNY),
            new TruthItem("What's your favorite funny movie or TV show, and why?", CATEGORY_FUNNY),
            new TruthItem("Tell us about a time when you couldn't stop laughing uncontrollably.", CATEGORY_FUNNY),
            // Add more truths with respective categories
            new TruthItem("If you had a time machine, would you travel to the past or the future? What would you do there?", CATEGORY_RANDOM),
            new TruthItem("Share a random and interesting fact about yourself that most people don't know.", CATEGORY_RANDOM),
            new TruthItem("If you could have any superpower, but only for one day, what would it be and how would you use it?", CATEGORY_RANDOM),
            new TruthItem("What's the most unusual food you've ever tried, and did you like it?", CATEGORY_RANDOM),
            new TruthItem("If you could spend a day with any historical figure, who would it be and what would you do together?", CATEGORY_RANDOM),
            new TruthItem("Describe a dream you've had that you found particularly strange or surreal.", CATEGORY_RANDOM),
            new TruthItem("If you could swap lives with someone for a day, who would it be and why?", CATEGORY_RANDOM),
            new TruthItem("Share a random talent you have that not many people are aware of.", CATEGORY_RANDOM),
            new TruthItem("If you were stranded on a deserted island, what three things would you want to have with you?", CATEGORY_RANDOM),
            new TruthItem("What's the most adventurous thing you've ever done, or would like to do?", CATEGORY_RANDOM),
            new TruthItem("What is your most embarrassing childhood memory?", CATEGORY_EMBARRASSING),
            new TruthItem("Have you ever accidentally sent a text to the wrong person? What was it about?", CATEGORY_EMBARRASSING),
            new TruthItem("Share an embarrassing moment you've had in a public place.", CATEGORY_EMBARRASSING),
            new TruthItem("What's the most embarrassing thing that happened to you on a date?", CATEGORY_EMBARRASSING),
            new TruthItem("Tell us about a time when you tripped or fell in front of others.", CATEGORY_EMBARRASSING),
            new TruthItem("Have you ever had food stuck in your teeth and didn't realize it? What happened?", CATEGORY_EMBARRASSING),
            new TruthItem("Share an embarrassing story from a family gathering.", CATEGORY_EMBARRASSING),
            new TruthItem("What's the most embarrassing song on your playlist?", CATEGORY_EMBARRASSING),
            new TruthItem("Have you ever walked into a room and completely forgot why you went there?", CATEGORY_EMBARRASSING),
            new TruthItem("Tell us about a wardrobe malfunction you've experienced.", CATEGORY_EMBARRASSING),
    };

    TruthItem[] dares = new TruthItem[]{
            new TruthItem("Rate everyone in the room from 1 to 10, with 10 being the best personality.", CATEGORY_FUNNY),
            new TruthItem("Go next door with a measuring cup and ask for a cup of sugar.", CATEGORY_EMBARRASSING),
            new TruthItem("Open Facebook, go to the account of the first person you see, and like every post on their wall going back to a year.", CATEGORY_EMBARRASSING),
            new TruthItem("Call your crush and sing 'Happy Birthday' to them.", CATEGORY_EMBARRASSING),
            new TruthItem("Eat a spoonful of mustard.", CATEGORY_EMBARRASSING),
            new TruthItem("Write a letter to your doctor describing an embarrassing rash you have, and post it on Facebook.", CATEGORY_EMBARRASSING),
            new TruthItem("Let the group choose three random things from the refrigerator and mix them together. Then you have to eat it.", CATEGORY_CHALLENGING),
            new TruthItem("Dig through the trash and name everything you find.", CATEGORY_CHALLENGING),
            new TruthItem("Call a NY-style pizza place and ask them what the difference is between NY pizza and 'real' pizza.", CATEGORY_CHALLENGING),
            new TruthItem("Take a selfie with the toilet and post it online.", CATEGORY_CHALLENGING),
            // Additional Dares - Embarrassing
            new TruthItem("Go outside and sing your favorite embarrassing song at the top of your lungs.", CATEGORY_EMBARRASSING),
            new TruthItem("Put on socks on your hands and try to make everyone laugh with your impromptu comedy routine.", CATEGORY_EMBARRASSING),
            new TruthItem("Send a funny, self-deprecating joke to three of your friends.", CATEGORY_EMBARRASSING),
            new TruthItem("Tell a joke that makes everyone laugh or do a funny dance for one minute.", CATEGORY_EMBARRASSING),
            new TruthItem("Act like a stand-up comedian and try to make the group laugh for two minutes.", CATEGORY_EMBARRASSING),
            // Add more dares with respective categories
            new TruthItem("Create a random and silly dance, and everyone has to join in for one minute.", CATEGORY_RANDOM),
            new TruthItem("Find a random item in the room and create a short, funny commercial to sell it to the group.", CATEGORY_RANDOM),
            new TruthItem("Speak in a random accent for the next three rounds.", CATEGORY_RANDOM),
            new TruthItem("Come up with a funny and fictional superhero name for yourself.", CATEGORY_RANDOM),
            new TruthItem("Do an impression of a famous celebrity, and the group has to guess who it is.", CATEGORY_RANDOM),

            //CATEGORY_FUNNY
            new TruthItem("Do your best impression of a famous comedian.", CATEGORY_FUNNY),
            new TruthItem("Create a funny, made-up dance and perform it for everyone.", CATEGORY_FUNNY),
            new TruthItem("Tell a joke that can make everyone laugh.", CATEGORY_FUNNY),
            new TruthItem("Wear socks on your hands and try to perform everyday tasks for the next 5 minutes.", CATEGORY_FUNNY),
            new TruthItem("Pretend to be a news anchor reporting a funny and bizarre story.", CATEGORY_FUNNY),
            new TruthItem("Make a funny face and keep it that way until your next turn.", CATEGORY_FUNNY),
            new TruthItem("Send a funny selfie to the third person in your contact list.", CATEGORY_FUNNY),
            new TruthItem("Do your best animal impression and keep it going for a minute.", CATEGORY_FUNNY),
            new TruthItem("Act like a stand-up comedian and perform a funny monologue.", CATEGORY_FUNNY),
            new TruthItem("Wear socks on your ears for the next 10 minutes.", CATEGORY_FUNNY),


    };
}
